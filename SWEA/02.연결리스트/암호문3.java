import java.io.*;
import java.util.*;

public class 암호문3 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= 10; t++) {
			sb.append("#" + t + " ");
			int N = Integer.parseInt(br.readLine());
			LinkedList<String> list = new LinkedList<>();

			st = new StringTokenizer(br.readLine());
			init(st, list, N);

			int M = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				String order = st.nextToken();

				if (order.equals("I"))
					insert(st, list);
				if (order.equals("D"))
					delete(st, list);
				if (order.equals("A"))
					add(st, list);
			}

			for (int i = 0; i < 10; i++) {
				sb.append(list.get(i) + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
		br.close();
	}

	static void init(StringTokenizer st, LinkedList<String> list, int N) {
		for (int i = 0; i < N; i++) {
			list.add(st.nextToken());
		}
	}

	static void insert(StringTokenizer st, LinkedList<String> list) {
		int idx = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());

		for (int i = 0; i < n; i++) {
			list.add(idx + i, st.nextToken());
		}
	}

	static void delete(StringTokenizer st, LinkedList<String> list) {
		int idx = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());

		for (int i = 0; i < n; i++) {
			list.remove(idx + i);
		}
	}

	static void add(StringTokenizer st, LinkedList<String> list) {
		int n = Integer.parseInt(st.nextToken());

		for (int i = 0; i < n; i++) {
			list.add(st.nextToken());
		}
	}

}
