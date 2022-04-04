import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj11720 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int result = 0;
        String[] str = br.readLine().split("");
        for (int i = 0; i < str.length; i++) {
            result += Integer.parseInt(str[i]);
        }

        System.out.println(result);

    }

}
