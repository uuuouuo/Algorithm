import java.util.*;

class Solution {
    // 최소 신장 트리 -> 사이클 형성 x
    // 간선 수 - 1 일때 최소비용
    // 최소비용 알고리즘 : 크루스칼, 프림 알고리즘
    public int solution(int n, int[][] costs) {

        // 크루스칼 알고리즘 사용하기 위해 가중치 기준 정렬
        Arrays.sort(costs, (int[] c1, int[] c2) -> c1[2] - c2[2]);

        // union 사용위해 부모 배열 선언
        int[] parent = new int[n];
        for (int i = 0; i < n; i++)
            parent[i] = i; // 자기 자신으로 초기화

        int answer = 0;

        for (int i = 0; i < costs.length; i++) {
            int from = costs[i][0];
            int to = costs[i][1];
            int cost = costs[i][2];

            int fromP = findParent(parent, from);
            int toP = findParent(parent, to);

            if (fromP == toP)
                continue; // 서로 부모노드가 같을때 (=사이클 생성) 패스
            answer += cost; // 다리 생성 (연결)
            parent[toP] = fromP; // 연결했으니까 부모 노드 갱신

        }
        return answer;
    }

    static int findParent(int[] parent, int node) {
        if (parent[node] == node)
            return node; // 부모노드가 자기자신일때 :루프
        return findParent(parent, parent[node]); // 루프노드 찾을때까지
    }
}
