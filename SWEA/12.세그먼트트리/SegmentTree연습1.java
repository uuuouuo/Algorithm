import java.io.*;
import java.util.*;

public class SegmentTree연습1 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            sb.append("#" + t + " ");

            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); // 배열 길이
            int q = Integer.parseInt(st.nextToken()); // 쿼리 수
            int[] arr = new int[n];
            int[] minTree = new int[n * 4];
            int[] maxTree = new int[n * 4];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            setMinTree(arr, minTree, 0, n-1, 1);
            setMaxTree(arr, maxTree, 0, n-1, 1);
            for (int j = 0; j < n * 4; j++) {
                System.out.print(minTree[j] + " ");
            }
            System.out.println();
            for (int j = 0; j < n * 4; j++) {
                System.out.print(maxTree[j] + " ");
            }
            System.out.println();
            for (int i = 0; i < q; i++) {
                st = new StringTokenizer(br.readLine());
                int cmd = Integer.parseInt(st.nextToken());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                if (cmd == 0) {
                    updateMinTree(arr, minTree, 0, n-1, 1, a, b);
                    updateMaxTree(arr, maxTree, 0, n-1, 1, a, b);
                    for (int j = 0; j < n * 4; j++) {
                        System.out.print(minTree[j] + " ");
                    }
                    System.out.println();
                    for (int j = 0; j < n * 4; j++) {
                        System.out.print(maxTree[j] + " ");
                    }
                    System.out.println();
                }
                if (cmd == 1) {
                    int max = getMax(arr, maxTree, 0, n - 1, 1, a, b - 1);
                    int min = getMin(arr, minTree, 0, n - 1, 1, a, b - 1);
                    System.out.println(max + " " + min );
                    sb.append(max - min + " ");
                }
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    static int setMinTree(int[] arr, int[] tree, int start, int end, int node) {
        if (start == end)
            return tree[node-1] = arr[start];

        int mid = (start + end) / 2;

        return tree[node-1] = Math.min(setMinTree(arr, tree, start, mid, node * 2),
                setMinTree(arr, tree, mid + 1, end, node * 2 + 1));
    }

    static int setMaxTree(int[] arr, int[] tree, int start, int end, int node) {
        if (start == end)
            return tree[node-1] = arr[start];

        int mid = (start + end) / 2;

        return tree[node-1] = Math.max(setMaxTree(arr, tree, start, mid, node * 2),
                setMaxTree(arr, tree, mid + 1, end, node * 2 + 1));
    }

    static int getMin(int[] arr, int[] tree, int start, int end, int node, int left, int right) {
        if (right < start || end < left)
            return arr[left];

        if (left <= start && end <= right)
            return tree[node-1];

        int mid = (start + end) / 2;

        return Math.min(getMin(arr, tree, start, mid, node * 2, left, right),
                getMin(arr, tree, mid + 1, end, node * 2 + 1, left, right));
    }

    static int getMax(int[] arr, int[] tree, int start, int end, int node, int left, int right) {
        if (right < start || end < left)
            return arr[right];

        if (left <= start && end <= right)
            return tree[node-1];

        int mid = (start + end) / 2;

        return Math.max(getMax(arr, tree, start, mid, node * 2, left, right),
                getMax(arr, tree, mid + 1, end, node * 2 + 1, left, right));
    }

    static void updateMinTree(int[] arr, int[] tree, int start, int end, int node, int targetIdx, int val) {
        System.out.println(start+" ~ "+end);
        // 범위 안인 경우 갱신
        if (start <= targetIdx && targetIdx <= end)
            tree[node-1] = Math.min(val, tree[node-1]);
        // 범위 밖인 경우
        else
            return;
            System.out.println((node-1) +"->"+tree[node-1]);
        if (start == end)
            return;

        int mid = (start + end) / 2;
        updateMinTree(arr, tree, start, mid, node * 2, targetIdx, val);
        updateMinTree(arr, tree, mid + 1, end, node * 2 + 1, targetIdx, val);
    }

    static void updateMaxTree(int[] arr, int[] tree, int start, int end, int node, int targetIdx, int val) {
        
        // 범위 안인 경우
        if (start <= targetIdx && targetIdx <= end)
            tree[node-1] = Math.max(val, tree[node-1]);
            // 범위 밖인 경우
            else return;
            

        if (start == end)
            return;

        int mid = (start + end) / 2;
        updateMaxTree(arr, tree, start, mid, node * 2, targetIdx, val);
        updateMaxTree(arr, tree, mid + 1, end, node * 2 + 1, targetIdx, val);
    }

}