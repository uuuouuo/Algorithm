import java.util.*;

class Solution {

    static long answer;
    static boolean[] visited;
    static String[] result;
    static List<String> oper;

    public long solution(String expression) {
        answer = 0;
        expression = replace(expression);

        // 연산자 구하기
        oper = new ArrayList<>();
        getOper(expression);

        // 연산자 우선순위 순열 돌리기
        int N = oper.size();
        visited = new boolean[N];
        result = new String[N];
        perm(expression, N, 0);

        return answer;
    }

    static String replace(String expression) {
        expression = expression.replace("+", " + ");
        expression = expression.replace("-", " - ");
        expression = expression.replace("*", " * ");

        return expression;
    }

    static void getOper(String expression) {
        String[] exp = expression.split(" ");
        for (String e : exp) {
            if ((e.equals("*") || e.equals("+")
                    || e.equals("-")) && !oper.contains(e))
                oper.add(e);
        }
    }

    static void perm(String expression, int N, int idx) {
        // 가장 큰 값 저장
        if (idx == N) {
            long res = getRes(expression, result);
            if (answer < res)
                answer = res;
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                result[idx] = oper.get(i);
                visited[i] = true;
                perm(expression, N, idx + 1);
                visited[i] = false;
            }
        }
    }

    static long getRes(String expression, String[] result) {
        for (String r : result)
            expression = change(expression, r);

        expression = expression.replace("-", "");
        return Long.parseLong(expression);
    }

    static String change(String expression, String oper) {
        String[] exp = expression.split(" ");

        for (int i = 0; i < exp.length; i++) {
            if (oper.equals(exp[i])) {
                long n = Long.parseLong(exp[i - 1]);
                long m = Long.parseLong(exp[i + 1]);
                expression = calc(expression, exp[i], n, m);

                return change(expression, oper);
            }
        }
        return expression;
    }

    static String calc(String expression, String oper, long n, long m) {
        long val = 0L;

        if (oper.equals("*"))
            val = n * m;
        if (oper.equals("+"))
            val = n + m;
        if (oper.equals("-"))
            val = n - m;

        String str = String.valueOf(n) + " " + oper + " " + String.valueOf(m);
        expression = expression.replace(str, String.valueOf(val));

        return expression;
    }

}