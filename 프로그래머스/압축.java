import java.util.*;

class Solution {

    static int idx;
    static HashMap<String, Integer> dic;
    static List<Integer> ans;

    public List<Integer> solution(String msg) {
        idx = 1;
        dic = new HashMap<>();
        ans = new ArrayList<>();
        init();
        go(msg);

        return ans;
    }

    static void init() {
        for (char i = 'A'; i <= 'Z'; i++)
            dic.put(i + "", idx++);
    }

    static void go(String msg) {
        int N = msg.length();
        int i = 0;

        l: while (i < N) {
            for (int j = 1; j <= N - i; j++) { // 사전에서 찾는 길이
                if (!dic.containsKey(msg.substring(i, i + j))) { // 사전에 없다면
                    i = addDic(msg, i, j);
                    continue l; // 다음 글자로
                }
                if (i + j == N) { // 문자 끝까지 끝났을때
                    lastString(msg, i, N);
                    break l;
                }
            }
        }
    }

    static int addDic(String msg, int i, int j) {
        dic.put(msg.substring(i, i + j), idx++); // 사전에 없는거 추가
        ans.add(dic.get(msg.substring(i, i + j - 1))); // 찾은 사전 번호 추가
        return i + j - 1;
    }

    static void lastString(String msg, int i, int N) {
        if (i == N - 1)
            ans.add(dic.get(msg.substring(N - 1))); // 맨마지막 idx 일때
        else
            ans.add(dic.get(msg.substring(i, N)));
    }

}