import java.io.*;

public class SWEA_중위순회 {

    static class Node {
        String data;
        String word;
        int left;
        int right;

        public Node(String data, String word, int left, int right) {
            this.data = data;
            this.word = word;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= 10; t++) {
            sb.append("#" + t + " ");
            int N = Integer.parseInt(br.readLine());
            Node[] node = new Node[N + 1];

            for (int i = 1; i <= N; i++) {
                String[] info = br.readLine().split(" ");
                setting(i, info, node);
            }

            inOrder(1, node, sb);
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void inOrder(int idx, Node[] node, StringBuilder sb) {
        Node cur = node[idx];
        if (cur.left != 0)
            inOrder(cur.left, node, sb); // 왼쪽 노드가 있다면 왼쪽 노드 순회
        sb.append(cur.word); // 왼쪽노드 출력
        if (cur.right != 0)
            inOrder(cur.right, node, sb); // 오른쪽 노드가 있다면 오른쪽 노드 순회

    }

    static void setting(int idx, String[] info, Node[] node) {
        int size = info.length;
        String data = "", word = "";
        int left = 0, right = 0;

        for (int i = 0; i < size; i++) {
            data = info[0];
            word = info[1];
            if (size > 2)
                left = Integer.parseInt(info[2]);
            if (size > 3)
                right = Integer.parseInt(info[3]);

            node[idx] = new Node(data, word, left, right);
        }

    }

}
