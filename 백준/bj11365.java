package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj11365 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    while (true) {
      String str = br.readLine();
      if (str.equals("END"))
        break;

      String[] enc = str.split(" ");
      for (int i = enc.length - 1; i >= 0; i--) {
        String[] s = enc[i].split("");
        for (int j = s.length - 1; j >= 0; j--) {
          System.out.print(s[j]);
        }
        System.out.print(" ");
      }
      System.out.println();
    }
  }

}
