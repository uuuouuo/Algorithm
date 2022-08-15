
public class 세그먼트트리 {

    public static void main(String[] args) {
        int[] input = { 5, 8, 7, 3, 2, 5, 1, 8, 9, 8, 7, 3 };
        int[] tree = new int[input.length * 4];

        initTree(input, tree, 0, input.length - 1, 1);

        // for (int i = 0; i < tree.length; i++) {
        // System.out.println(tree[i]);
        // }

    }

    // 세그먼트 트리 생성 함수
    // start: 시작 인덱스, end: 끝 인덱스, node: 세그먼트 트리 인덱스 (무조건 1부터 시작)
    static int initTree(int[] input, int[] tree, int start, int end, int node) {
        if (start == end)
            return tree[node] = input[start];

        int mid = (start + end) / 2;

        // 병합정렬 늬낌
        return tree[node] = initTree(input, tree, start, mid, node * 2) // 왼쪽 노드
                + initTree(input, tree, mid + 1, end, node * 2 + 1); // 오른쪽 노드
    }

    // 구간 합 구하는 함수
    // start: 시작 인덱스, end: 끝 인덱스
    // left, right: 구간 범위
    static int sum(int[] input, int[] tree, int start, int end, int node, int left, int right) {
        // 범위 밖인 경우
        if (left > end || right < start)
            return 0;
        // 범위 안인 경우
        if (left <= start && right >= end)
            return tree[node];

        // 둘 다 아니면 구간 나누어 합 구하기
        int mid = (start + end) / 2;
        return sum(input, tree, start, mid, node * 2, left, right)
                + sum(input, tree, mid + 1, end, node * 2 + 1, left, right);
    }

    // 특정 원소 값 수정 함수
    // start: 시작 인덱스, end: 끝 인덱스
    // targetIdx: 수정하고자 하는 노드 인덱스
    // val: 수정할 값
    static void updateTree(int[] tree, int start, int end, int node, int targetIdx, int val) {
        // 범위 밖인 경우
        if (targetIdx < start || targetIdx > end)
            return;
        // 범위 안인 경우
        // 내려가며 다른 원소 갱신?
        tree[node] += val;

        if (start == end)
            return;

        int mid = (start + end) / 2;
        updateTree(tree, start, mid, node * 2, targetIdx, val);
        updateTree(tree, mid + 1, end, node * 2 + 1, targetIdx, val);
    }
}
