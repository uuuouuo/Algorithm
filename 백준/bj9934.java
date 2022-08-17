package 백준;
import java.io.*;
import java.util.*;

public class bj9934 {

  static int K, N, arr[];
  static List<Integer> list[];

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    K = Integer.parseInt(br.readLine()); // 깊이 입력
    N = (int) Math.pow(2, K) - 1; // 노드 수
    arr = new int[N];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken()); // preOrder (전위순회) 순서 입력
    }

    list = new List[K];
    for (int i = 0; i < K; i++) {
      list[i] = new ArrayList<>();
    }

    findRoot(0, N - 1, 0);

    for (int i = 0; i < K; i++) {
      for (int j = 0; j < list[i].size(); j++) {
        System.out.print(list[i].get(j) + " ");
      }
      System.out.println();
    }

  }

  static void findRoot(int low, int high, int depth) {
    if (depth == K)
      return;
    int mid = (low + high) / 2;
    list[depth].add(arr[mid]);
    // System.out.println(arr[mid]);

    // low 방향, high 방향 root 찾기
    findRoot(low, mid - 1, depth + 1);
    findRoot(mid + 1, high, depth + 1);

  }

}
