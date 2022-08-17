package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class bj5568 {

  static int n, k;
  static String input[];
  static boolean visited[];

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine()); // 주어진 숫자 개수
    k = Integer.parseInt(br.readLine()); // 합칠 숫자 수

    visited = new boolean[n];
    input = new String[n];
    for (int i = 0; i < n; i++) {
      input[i] = br.readLine();
    }

    hs = new HashSet<>(); // 중복을 걸러주는 리스트
    solution1(0, "");
    System.out.println(hs.size());

    // System.out.println("----------");
    // list = new ArrayList<>();
    // result = new String[k];
    // solution2(0, 0);
    // System.out.println(list.size());
  }

  static HashSet<String> hs;

  static void solution1(int idx, String str) { // 순열 (중복 제거를 위해 hashSet 사용)

    if (k == idx) {
      System.out.println(str);
      hs.add(str);
      return;
    }

    for (int i = 0; i < n; i++) {
      if (!visited[i]) {
        visited[i] = true;
        solution1(idx + 1, str + input[i]);
        visited[i] = false;
      }
    }

  }

  // static List<String> list;
  // static String result[];
  // static void solution2(int start, int idx) { // 순열

  // if(k == idx) {
  // String str = "";
  // for (int i = 0; i < k; i++) {
  // str += result[i];
  // }
  // System.out.println(str);
  // list.add(str);
  // return;
  // }

  // for (int i = start; i < n; i++) {
  // if(!visited[i]) {
  // result[idx] = input[i];
  // visited[i] = true;
  // solution2(i + 1, idx + 1);
  // visited[i] = false;
  // // str = "";
  // }
  // }

  // }

}
