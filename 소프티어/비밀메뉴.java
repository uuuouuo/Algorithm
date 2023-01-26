package 소프티어;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 비밀메뉴 {

    static int M, N, K, menu[], arr[];
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken()); // 비밀 메뉴 조작법 길이
        N = Integer.parseInt(st.nextToken()); // 사용자의 버튼 조작 길이
        K = Integer.parseInt(st.nextToken()); // 최대 숫자

        menu = new int[M];
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++) {
            menu[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        if(go()) System.out.println("secret");
        else System.out.println("normal");

    }

    static boolean go() {
        int mIdx = 0; // 비밀메뉴 인덱스
        int curIdx = 0;
        int preIdx = 0;
        boolean isExit = false;

        while(curIdx < N) {

            // 검사하는 중(mIdx != 0) 맨 처음 메뉴를 만났다면 저장해두기(menu[0] == arr[curIdx])
            // 전에 만난적 있다면 넘어가기 (!isExit)
            if(!isExit && mIdx != 0 && menu[0] == arr[curIdx]) {
                isExit = true;
                preIdx = curIdx;
            }

            // 비밀 메뉴와 일치한다면
            if(menu[mIdx] == arr[curIdx]) {
                mIdx++;
                curIdx++;

                // 비밀메뉴 끝까지 같으면 true 반환
                if(mIdx == M) return true;
            }
            // 비밀 메뉴와 다르다면
            else {
                mIdx = 0; // 다시 처음부터 체크

                // 이전에 첫글자가 나왔다면
                if(isExit) {
                    curIdx = preIdx; // 그곳부터 시작
                    isExit = false; // 원래 상태로
                }
                // 안나왔으면 다음으로
                else curIdx++;
            }

        }

        return false;
    }

}
