import java.io.*;
import java.util.*;
import java.util.regex.*;

public class 사칙연산 {

    static class Node {
        int idx;
        String data;
        int left;
        int right;

        public Node(int idx, String data, int left, int right) {
            this.idx = idx;
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= 10; t++) {
            sb.append("#" + t + " ");
            int N = Integer.parseInt(br.readLine());
            Node[] node = new Node[N + 1];

            for (int i = 0; i < N; i++)
                setting(node, br.readLine());

            st = new Stack<>();
            postOrder(1, node);
            double answer = st.pop();
            sb.append((int) answer + "\n");
        }
        System.out.println(sb);

    }

    static Stack<Double> st;

    static void compute(String data) {
        Pattern p = Pattern.compile("^[0-9]*$");
        if (p.matcher(data).matches())
            st.push(Double.parseDouble(data));

        else {
            double tmp = 0;
            double num1 = st.pop(), num2 = st.pop();

            if (data.equals("+"))
                tmp = num2 + num1;
            if (data.equals("-"))
                tmp = num2 - num1;
            if (data.equals("/"))
                tmp = num2 / num1;
            if (data.equals("*"))
                tmp = num2 * num1;
            st.push(tmp);
        }
    }

    static void postOrder(int i, Node[] node) {
        Node cur = node[i];
        if (cur.left != 0)
            postOrder(cur.left, node);
        if (cur.right != 0)
            postOrder(cur.right, node);
        compute(cur.data);
    }

    static void setting(Node[] node, String str) {
        String[] info = str.split(" ");
        int size = info.length;

        String data = "";
        int idx = 0, left = 0, right = 0;
        for (int i = 0; i < size; i++) {
            idx = Integer.parseInt(info[0]);
            data = info[1];
            if (size == 4) {
                left = Integer.parseInt(info[2]);
                right = Integer.parseInt(info[3]);
            }
            node[idx] = new Node(idx, data, left, right);
        }

    }

}
