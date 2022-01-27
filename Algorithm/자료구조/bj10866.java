package 자료구조;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;

public class bj10866 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		
		Deque<String> deq = new LinkedList<String>();
		
		for (int i = 0; i < N; i++) {
			
			String str = br.readLine();
			String[] spt = str.split(" ");
			
			if(spt[0].equals("push_front")) {
				deq.addFirst(spt[1]);
			}
			
			else if(spt[0].equals("push_back")) {
				deq.addLast(spt[1]);
			}
			
			else if(spt[0].equals("pop_front")) {
				if(deq.isEmpty()) {
					bw.write(String.valueOf(-1));
				}else {
					bw.write(String.valueOf(deq.pollFirst()));					
				}
				bw.newLine();
			}
			
			else if(spt[0].equals("pop_back")) {
				if(deq.isEmpty()) {
					bw.write(String.valueOf(-1));
				}else {
					bw.write(String.valueOf(deq.pollLast()));					
				}
				bw.newLine();
			}
			
			else if(spt[0].equals("size")) {
				bw.write(String.valueOf(deq.size()));
				bw.newLine();
			}
			
			else if(spt[0].equals("empty")) {
				if(deq.isEmpty()) {
					bw.write(String.valueOf(1));
				}else {
					bw.write(String.valueOf(0));
				}
				bw.newLine();
			}
			
			else if(spt[0].equals("front")) {
				if(deq.isEmpty()) {
					bw.write(String.valueOf(-1));
				}else {
					bw.write(String.valueOf(deq.peekFirst()));
				}
				bw.newLine();
			}
			
			else if(spt[0].equals("back")) {
				if(deq.isEmpty()) {
					bw.write(String.valueOf(-1));
				}else {
					bw.write(String.valueOf(deq.peekLast()));
				}
				bw.newLine();
			}
			
		}
		
		bw.flush();
		bw.close();		
		
	}

}
