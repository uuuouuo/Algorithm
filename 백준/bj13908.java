package 백준;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class bj13908 {

  static int n, m;
  static boolean numbers[];
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
//    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    StringTokenizer st = new StringTokenizer(br.readLine());
//    n = Integer.parseInt(st.nextToken()); // 비번 길이
//    m = Integer.parseInt(st.nextToken()); // 아는 숫자 개수
    n = sc.nextInt(); // 비번 길이
    m = sc.nextInt(); // 아는 숫자 개수
    numbers = new boolean[10]; // 숫자 사용 체크 배열

//    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < m; i++) {
//      int know_num = Integer.parseInt(st.nextToken());
      int know_num = sc.nextInt();
      numbers[know_num] = true;
    }

    ans = 0;
    backtracking(0, 0);
    System.out.println(ans);

  }

  static int ans;
  private static void backtracking(int idx, int cnt) {

    if(idx == n) {
      if(cnt == m) {
        ans++;
        System.out.println("ans++");
      }
      return;
    }

    for (int i = 0; i < 10; i++) {
      System.out.println("idx: " + idx + "  i: " + i);
      if(numbers[i]) {
        numbers[i] = false;
        backtracking(idx + 1, cnt + 1);
        numbers[i] = true;
      }
      else backtracking(idx + 1, cnt);
      // idx 가 2가 됐지만 return 되면
      // 🔻 여기 for 문이 도는 것!
    }

  }

}
