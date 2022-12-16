package 프로그래머스;

class 두개이하로다른비트 {
    // 시간초과 주의
    // 규칙 찾아 푸는 구현(?)
    // 짝수 ->  0으로 끝남, 마지막 비트 1로 바꿔주면 돼 => 따라서 타겟 숫자에 1 더한 값이 답
    // 홀수는  두가지 경우
        // 1. 모두 1인 경우 -> 맨앞자리 제외하고 10 붙이기
        // 2. 0이 포함된 경우 -> 맨 마지막 0을 1로 변경 후 그 뒤 1을 0으로 변경
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length]; // x보다 크고 x와 비트가 1~2개 다른 수들 중에서 제일 작은 수
        for(int i=0; i<numbers.length; i++) {          
            if(numbers[i]%2  == 0) {
                answer[i] = numbers[i] + 1;
            } else {
                String bit = Long.toString(numbers[i], 2); // 10진법 수 String 형태로 2진법 비트 변환
                StringBuilder sb =  new StringBuilder();
                
                if(!bit.contains("0")) {
                    sb.append("10");
                    sb.append(bit.substring(1));
                } else {
                    int zeroIdx = bit.lastIndexOf("0"); // "0"의 마지막 인덱스
                    sb.append(bit.substring(0, zeroIdx) + 10); // 마지막 0 인덱스 앞까지 + zeroIdx는 1로 변환하고 그 뒤는 0으로 변환
                    sb.append(bit.substring(zeroIdx+2));
                }
                answer[i] = Long.parseLong(sb.toString(), 2); // 2진법 수 String을 Long형태로 변환
            }
        }
        return answer;
    }
}