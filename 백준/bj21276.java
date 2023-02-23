package 백준;

import java.io.*;
import java.util.*;

public class bj21276 {

    // treeMap<이름, 자식 treeSet> => 자식 수, 이름 확인 가능
    // 가문의 개수 => boolean 처리?
    // 시조 => treeSet만 있는 list만들어서 개수 내림차순 순서대로 boolean 처리 => dfs

    static int N, M;
    static Map<String, TreeSet<String>> map;
    static Set<String> check;
    static List<String> parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine()); // 석호촌 사람 수

        map = new TreeMap<>(); // <부모, 자식들> 담을 map
        check = new HashSet<>(); // 방문 체크 set -> 확인한 사람이면 지우기

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            String name = st.nextToken();

            TreeSet<String> set = new TreeSet<>();
            map.put(name, set);
            check.add(name);
        }

        M = Integer.parseInt(br.readLine()); // 주어지는 정보 수

        // 자식, 부모 정보 저장
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String c = st.nextToken();
            String p = st.nextToken();

            TreeSet<String> set = map.get(p); // 해당 부모의 자식 set
            set.add(c); // 자식 추가
        }

//        map.forEach((k, v) -> {
//            System.out.println(k+" "+v.size());
//            for(String c : v)
//                System.out.println(c);
//        });

        parent = new ArrayList<>(); //제일 윗 조상 저장
        go();
        print();

    }


    private static void go() {
        // 우선순위 큐 사용하기로 변경 !
        // 우선순위 큐에 담아서 자식 수가 많은 순으로 정렬
        // parent 에 가장 윗 조상만 저장되게 됨 -> 다 체크 됨
        PriorityQueue<Node> q = new PriorityQueue<>((o1, o2) -> o2.num - o1.num);
        map.forEach((k, v) -> q.add(new Node(k, v.size())));

        while(!q.isEmpty()) {
            Node node = q.poll();

            // 아직 확인 안한 사람이라면
            if(check.contains(node.name)) {
                parent.add(node.name);
                dfs(node.name);
            }
        }

    }

    private static void dfs(String name) {
        System.out.println(name);
        // 확인한 사람 탐색 대상에서 제거
        check.remove(name);

        // 해당 사람의 자식 중
        map.get(name).forEach(child -> {
            // 탐색 대상에 있다면
            if(check.contains(child)) dfs(child);
        });
    }


    private static void print() {
        StringBuilder sb = new StringBuilder();
        sb.append(parent.size() + "\n");

        for(String p : parent)
            sb.append(p + " ");

        sb.append("\n");
        map.forEach((k, v) -> {
            sb.append(k+" "+v.size()+" ");

            v.forEach(c -> sb.append(c+" "));
            sb.append("\n");
        });

        System.out.println(sb.toString());
    }


    /** Comparable과 Comparator의 차이
     * 전자는 자기자신과 비교 compareTo(this, o)
     * 후자는 두개의 매개변수와 비교 compare(o1, o2) */
    static class Node {
        String name;
        int num;

        public Node(String name, int num) {
            this.name = name;
            this.num = num;
        }
    }
}
