package Directory;

import java.util.*;

class UserSolution {

    private final static int NAME_MAXLEN = 6; // 디렉토리 이름 최대
    private final static int PATH_MAXLEN = 1999; // 깊이 길이 최대

    static class Node {
        String name; // 디렉토리 이름
        // List<Node> cList;
        HashMap<String, Node> cMap; // 자식노드 저장
        Node p; // 부모노드
        int cnt; // 하위 디렉토리의 노드수

        public Node(String name) {
            this.name = name;
            cMap = new HashMap<>();
        }

    }

    static class Directory {
        Node root;

        // Directory 초기 생성
        public Directory() {
            root = new Node("/");
        }

        public Node findNode(String target) {
            if (target.equals("/"))
                return dir.root;

            String[] route = target.split("/");
            Node n = dir.root;

            for (int i = 1; i < route.length; i++)
                n = n.cMap.get(route[i]);

            return n;
        }

        public void copyNode(Node copyNode, Node toNode) {
            if (copyNode.cMap.isEmpty())
                return;

            copyNode.cMap.forEach((k, v) -> {
                Node tmpNode = new Node(k);
                tmpNode.cnt = v.cnt;
                tmpNode.p = toNode;

                toNode.cMap.put(tmpNode.name, tmpNode);
                // 해당 노드 자식들도 복사 (재귀)
                dir.copyNode(v, toNode.cMap.get(tmpNode.name));
            });
        }
    }

    // ---------------------------------------------------------------------------------
    static int N;
    static Directory dir;

    void init(int n) {
        N = n;
        dir = new Directory();
    }

    void cmd_mkdir(char[] path, char[] name) {
        Node nNode = new Node(new String(name, 0, name.length - 1));
        Node pNode = null;

        // 루트노드라면
        if (path.length == 2) {
            nNode.p = dir.root;
            dir.root.cnt++;
            dir.root.cMap.put(nNode.name, nNode);
            return;
        }

        // 그외 부모노드 찾기
        pNode = dir.findNode(new String(path, 0, path.length - 1));

        nNode.p = pNode;
        pNode.cMap.put(nNode.name, nNode);

        while (pNode != null) { // 자식노드 개수 추가
            pNode.cnt++;
            pNode = pNode.p;
        }
    }

    void cmd_rm(char[] path) {
        Node target = dir.findNode(new String(path, 0, path.length - 1));
        target.p.cMap.remove(target.name);

        int cnt = target.cnt + 1; // 자기포함 삭제 노드 개수
        Node pNode = target.p;

        while (pNode != null) {
            pNode.cnt -= cnt;
            pNode = pNode.p;
        }
    }

    void cmd_cp(char[] srcPath, char[] dstPath) {
        Node copyNode = dir.findNode(new String(srcPath, 0, srcPath.length - 1));
        Node toNode = dir.findNode(new String(dstPath, 0, dstPath.length - 1));

        Node tmpNode = new Node(copyNode.name);
        tmpNode.cnt = copyNode.cnt;
        tmpNode.p = toNode;

        toNode.cMap.put(tmpNode.name, tmpNode); // 복사할 노드 생성
        dir.copyNode(copyNode, tmpNode); // 그 밑부터 하나씩 복사

        int cnt = copyNode.cnt + 1; // 자기포함 추가 노드 개수

        // 추가노드 수만큼 부모노드의 자식노드수 더하기
        while (toNode != null) {
            toNode.cnt += cnt;
            toNode = toNode.p;
        }
    }

    void cmd_mv(char[] srcPath, char[] dstPath) {
        cmd_cp(srcPath, dstPath);
        cmd_rm(srcPath);
    }

    int cmd_find(char[] path) {
        if (path.length == 2)
            return dir.root.cnt;
        return dir.findNode(new String(path, 0, path.length - 1)).cnt;
    }

}