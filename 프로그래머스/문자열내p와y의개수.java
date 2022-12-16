package 프로그래머스;

class 문자열내p와y의개수 {
    boolean solution(String s) {
        int pCnt = 0;
        int yCnt = 0;

        s = s.toLowerCase();
        for (char c : s.toCharArray()) {
            if (c == 'p')
                pCnt++;
            if (c == 'y')
                yCnt++;
            // System.out.println(c);
        }
        if (pCnt == yCnt)
            return true;
        return false;
    }
}