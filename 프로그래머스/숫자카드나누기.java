package 프로그래머스;

class 숫자카드나누기 {
    static int answer;
    public int solution(int[] arrayA, int[] arrayB) {
        answer = 0;
        go(arrayA, arrayB);
        go(arrayB, arrayA);
        return answer;
    }
    
    static void go(int[] arr1, int[] arr2) {       
        // 2 ~ 가장 작은 원소까지 조건 확인
        l: for(int i=2; i<=arr1[0]; i++) {
            for(int n:arr1) {
                if(n%i != 0) continue l;
            }            
            for(int n:arr2) {
                if(n%i == 0) continue l;
            }
            if(answer < i) answer = i;
        }
    }
}