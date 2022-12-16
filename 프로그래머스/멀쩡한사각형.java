package 프로그래머스;

class 멀쩡한사각형 {
    // 1. 최대 공약수 구하기
    // 2. 공식에 넣어 구하기
    public long solution(int w, int h) {
        long small = 0, big = 0;
        if (w < h) {
            small = (long) w;
            big = (long) h;
        } else {
            small = (long) h;
            big = (long) w;
        }

        long gcd = gcd(small, big);
        return small * big - (small / gcd + big / gcd - 1) * gcd;
    }

    static long gcd(long small, long big) {
        long tmp = 0;
        while (small > 0) {
            tmp = big % small;
            big = small;
            small = tmp;
        }

        return big;
    }
}