package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class bj18258 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		Deque<String> q = new LinkedList<String>();
		
		for (int i = 0; i < N; i++) {
			String str[] = br.readLine().split(" ");
			
			if(str[0].equals("push")) {
				String num = str[1];
				q.add(num);
			}
			else if(str[0].equals("pop")) {
				bw.write(q.isEmpty() ? "-1" : q.poll());
				bw.newLine();
			}
			else if(str[0].equals("size")) {
				bw.write(q.size());
				bw.newLine();
			}
			else if(str[0].equals("empty")) {
				bw.write(q.isEmpty() ? "1" : "0");
				bw.newLine();
			}
			else if(str[0].equals("front")) {
				bw.write(q.isEmpty() ? "-1" : q.peek());
				bw.newLine();
			}
			else if(str[0].equals("back")) {
				bw.write(q.isEmpty() ? "-1" : q.peekLast());
				bw.newLine();
			}
		}
		bw.flush();
		bw.close();		
	}

}
