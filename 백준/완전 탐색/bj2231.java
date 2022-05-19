import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj2231 {

  static int N, R, num[];
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String input = br.readLine();
    N = Integer.parseInt(input);
    R = input.length();
    num = new int[10];
    res = new int[R];
    for (int i = 0; i < 10; i++) {
      num[i] = i;
    }
    solution( 0);

  }

  static int res[];
  private static void solution(int idx) { //  중복 순열

    if(idx == R) {

      int ans = 0;
      for (int i = 0; i < R; i++) {
        ans += res[i] * Math.pow(10, R - 1 - i);
//        System.out.println(ans);
      }

      // 주어진 수보다 크면 생성자 x
      if(ans >= N) {
        System.out.println(0);
        System.exit(0);
      }

      // 분해합 실행
      int check = ans;
      for (int i = 0; i < R; i++) {
        check += res[i];
      }

      if(check == N) {
        System.out.println(ans);
        System.exit(0);
      }
      return;
    }

    for(int i = 0; i < 10; i++) { // 0 ~ 9 선택
        res[idx] = num[i];
        solution(idx + 1);
    }

  }

}
