package 코딩테스트._2023상반기;

public class SKP2  {
    // 빵이 나오면 전부 팔림
    // 빵 시간표(100) : 시각 빵이 나오는 개수(1000) -> 오름차순 정렬, 중복시간 x
    // 현재시각
    // K (100000) 개 판매하려면 최소 몇분이 걸릴까

    // => 현재시각 = 나오는 시각 같으면 더하기!!!
    // k 개 못팔면 -1 표시

    static int N, curMin;
    public int solution(String[] bakery_schedule, String current_time, int k) {
        int answer = -1;
        N = bakery_schedule.length;
        curMin = toMin(current_time);

        int min, num;
        int stopTime = 0;
        int cnt = 0;
        for(int i=0; i<N; i++) { // 100
            String[] S = bakery_schedule[i].split(" ");
            min = toMin(S[0]); // 빵 만들어지는 시간
            num = Integer.parseInt(S[1]); // 만들어진 빵개수
            // System.out.println(min);

            if(min < curMin) continue; // 지금 시각보다 더 전이면 패스

            cnt += num; // 팔린 빵개수 더하기
            if(cnt >= k) { // 만약 k개수이상 팔았으면 그만
                stopTime = min; // 시각 저장
                break;
            }
        }
        // k개 까지 얼마나 (몇분) 걸리냐 ---> k개 이상일 때(시각) - 현재 시각
        if(stopTime == 0) answer = -1;
        else answer = stopTime - curMin;
        return answer;
    }

    static int toMin(String time) {
        int result = 0;
        String[] s = time.split(":");

        result += Integer.parseInt(s[0]) * 60;
        result += Integer.parseInt(s[1]);

        return result;
    }
}

