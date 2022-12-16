package 코딜리티;

class FrogJmp {
    public int solution(int X, int Y, int D) {
        int cnt = 0;
        int tmp = 0;
        while (Y > tmp) {
            // System.out.println(D);
            cnt++;
            tmp += D;
        }
        return cnt;
    }
}