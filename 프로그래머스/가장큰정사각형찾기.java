package 프로그래머스;

// 답 확인함.. 기억해두기!
// DP 문제
public class 가장큰정사각형찾기 {

    public int solution(int [][]board) {
        int answer = 0;
        int N = board.length + 1;
        int M = board[0].length + 1;

        int[][] arr = new int[N][M];

        for(int i = 1; i < N; i++) {
            for(int j = 1; j < M; j++) {
                // System.out.print(board[i-1][j-1] + " ");
                if(board[i-1][j-1] == 0) continue;

                int min = Math.min(Math.min(arr[i-1][j-1], arr[i-1][j]), arr[i][j-1]);

                arr[i][j] = min + 1;

                answer = Math.max(arr[i][j], answer);
            }
            // System.out.println();
        }

        // for(int i = 0; i < N; i++) {
        //     for(int j = 0; j < M; j++) {
        //         System.out.print(arr[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        return answer * answer;
    }

}
