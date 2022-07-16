import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class bj이건꼭풀어야해 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int q = Integer.parseInt(st.nextToken());
    int[] input = new int[n];
    int[] sum = new int[n+1];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      input[i] = Integer.parseInt(st.nextToken());
    }
    Arrays.sort(input);

    for (int i = 1; i <= n; i++) {
      if (i == 0) sum[i] = 0;
      else sum[i] = input[i-1] + sum[i-1];
    }

    for (int i = 0; i < q; i++) {
      st = new StringTokenizer(br.readLine());
      int l = Integer.parseInt(st.nextToken())-1;
      int r = Integer.parseInt(st.nextToken());
      System.out.println(sum[r]-sum[l]);
    }
  }
}
