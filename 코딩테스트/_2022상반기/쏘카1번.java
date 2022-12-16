package 코딩테스트._2022상반기;


import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

// 올바른 괄호 문자열에서 하나의 문자가 빠졌을 때, 문자 하나를 적당한 위치에 집어넣으면 올바른 괄호 문자열을 만들 수 있다.
// 이 때, 만들 수 있는 올바른 괄호 문자열을 여러가지 만들 수 있는데, 올바른 괄호 문자열을 만들 수 있는 위치의 개수를 구하시오.
//1 <= s <= 500000
//  s : []([[]){}  answer : 3
//  s : {([()]))}   answer : 4
//  s : (()()()     answer : 7
public class 쏘카1번 {

    public static void main(String[] args) {
        String[] S = { "{([()]))}", "[]([[]){}", "(()()()" };
        for (String s : S)
            solution(s);
    }

    private static void solution(String s) {
        String solo = check(s);
        String target = getTarget(solo);
        answer = 0;
        go(s, target);
    }

    static int answer;

    private static void go(String str, String target) {
        String[] s = str.split("");
        int idx = 0;
        while (idx < str.length() + 1) {
            String tmp = "";
            for (int i = 0; i < str.length() + 1; i++) {
                if (i == idx)
                    tmp += target;
                if (i != str.length())
                    tmp += s[i];
            }

            if (isOk(tmp))
                answer++;
            idx++;

        }
    }

    private static boolean isOk(String tmp) {
        Deque<String> q = new LinkedList<>();
        initQ(q, tmp);

        while (!q.isEmpty()) {
            if (q.size() == 1)
                return false;
            String cur = q.poll();

            if ((cur.equals("]") && q.peekLast().equals("[")) ||
                    (cur.equals("}") && q.peekLast().equals("{")) ||
                    (cur.equals(")") && q.peekLast().equals("(")))
                q.pollLast();
            else if (cur.equals("(") || cur.equals("{") || cur.equals("["))
                q.add(cur);
            else
                return false;
        }
        return true;
    }

    private static void initQ(Queue<String> q, String str) {
        for (String s : str.split(""))
            q.add(s);
    }

    private static String getTarget(String solo) {
        if (solo.equals("]"))
            return "[";
        if (solo.equals("["))
            return "]";
        if (solo.equals("}"))
            return "{";
        if (solo.equals("{"))
            return "}";
        if (solo.equals("("))
            return ")";
        else
            return "(";
    }

    private static String check(String str) {
        Queue<String> q = new LinkedList<>();
        initQ(q, str);

        while (!q.isEmpty()) {
            if (q.size() == 1)
                return q.poll();
            String cur = q.poll();

            if (cur.equals("]") && q.remove("["))
                continue;
            else if (cur.equals("}") && q.remove("{"))
                continue;
            else if (cur.equals(")") && q.remove("("))
                continue;
            else
                q.add(cur);
        }
        return "";
    }

}
