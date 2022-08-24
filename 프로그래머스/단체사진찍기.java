class Solution {
    // 1. 모든 경우의 수 구하기
    // 2. 조건에 모두 부합한지 확인

    static int answer, gap[];
    static boolean[] visited;
    static char operation[], partner[][];
    static String[] friends = { "A", "C", "F", "J", "M", "N", "R", "T" };

    public static int solution(int n, String[] data) {
        answer = 0;
        visited = new boolean[8];
        partner = new char[n][2];
        gap = new int[n];
        operation = new char[n];

        for (int i = 0; i < n; i++) {
            String d = data[i];
            partner[i][0] = d.charAt(0);
            partner[i][1] = d.charAt(2);
            operation[i] = d.charAt(3);
            gap[i] = d.charAt(4) - '0';
            // System.out.println(partner[i][0]+" "+partner[i][1]+" "+operation[i]+"
            // "+gap[i]);
        }

        // 순서 o 중복 x : 순열
        perm(n, "");
        return answer;
    }

    static void perm(int n, String result) {
        if (result.length() == 7) {
            if (isOk(n, result))
                answer++;
            return;
        }

        for (int i = 0; i < 8; i++) {
            if (!visited[i]) {
                visited[i] = true;
                perm(n, result + friends[i]);
                visited[i] = false;
            }

        }
    }

    static boolean isOk(int n, String result) {
        // System.out.println(result);
        for (int i = 0; i < n; i++) {
            int tmp = Math.abs(result.indexOf(partner[i][0])
                    - result.indexOf(partner[i][1])) - 1;
            // System.out.println(partner[i][0]+" "+partner[i][1]+" "+operation[i]+"
            // "+gap[i]);
            // System.out.println(tmp);
            if (operation[i] == '=' && tmp != 0)
                return false;
            else if (operation[i] == '<' && tmp >= gap[i])
                return false;
            else if (operation[i] == '>' && tmp <= gap[i])
                return false;
        }
        return true;
    }
}