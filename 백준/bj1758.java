package 백준;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class bj1758 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Integer tip[] = new Integer[N];
		for (int i = 0; i < N; i++) {
			tip[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(tip, Collections.reverseOrder()); // int형 안돼

		long sum = 0;
		for (int i = 0; i < N; i++) {
			int tmp = tip[i] - i;

			if(tmp > 0)
				sum += tmp;
		}
		
		System.out.println(sum);

	}

}
