package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj1541 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] sub = br.readLine().split("-");

		int result = 0;
		int tmp = 0;

		for (int i = 0; i < sub.length; i++) {

			String add[] = sub[i].split("\\+");

			for (int j = 0; j < add.length; j++) {
				if (i == 0)
					tmp += Integer.parseInt(add[j]);
			}

			if (i == 0)
				result = tmp;
			else
				result -= tmp;

		}

		System.out.println(result);
	}

}
