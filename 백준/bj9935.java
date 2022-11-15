package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class  bj9935 { // 문자열폭발

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String bomb = br.readLine();

        Stack<Character> st = new Stack<>();
        l: for (int i = 0; i < str.length(); i++) {
            st.push(str.charAt(i));

            if(st.size() >= bomb.length()) {
                for (int j = 0; j < bomb.length(); j++) {
                    if(st.get(st.size()-bomb.length()+j) != bomb.charAt(j))
                        continue l;
                }
                for (int k = 0; k < bomb.length(); k++)
                    st.pop();
            }
        }

        if(st.size() == 0) System.out.println("FRULA");
        else {
            StringBuilder sb = new StringBuilder();
            for(char c : st) // 이렇게 하면 먼저 넣은 순으로 출력되나보다
                sb.append(c);
            System.out.println(sb.toString());
        }
    }
}
