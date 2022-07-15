import java.util.*;

public class bj수열 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int days = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        int answer = Integer.MIN_VALUE;
        for (int i = 0; i < n - days + 1; i++) {
            int tmp = 0;
            for (int d = 0; d < days; d++) {
                tmp += arr[i + d];
            }
            if (answer < tmp)
                answer = tmp;
        }

        System.out.println(answer);

    }

}
