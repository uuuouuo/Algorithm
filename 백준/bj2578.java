package 백준;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj2578 {

  static int bingoN, board[][], numbers[][];
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st =  null;

    // 빙고판 입력
    board = new int[5][5];
    for (int r = 0; r < 5; r++) {
      st = new StringTokenizer(br.readLine());
      for (int c = 0; c < 5; c++) {
        board[r][c] = Integer.parseInt(st.nextToken());
      }
    }

    // 사회자가 부를 숫자 입력
    numbers = new int[5][5];
    for (int r = 0; r < 5; r++) {
      st = new StringTokenizer(br.readLine());
      for (int c = 0; c < 5; c++) {
        numbers[r][c] = Integer.parseInt(st.nextToken());
      }
    }

    int res = 0;
    for (int i = 0; i < 5; i++) {
      for (int j = 0; j < 5; j++) {
        int n = numbers[i][j];
        res++;

        for (int r = 0; r < 5; r++) {
          for (int c = 0; c < 5; c++) {
            if(n == board[r][c]) board[r][c] =0;
          }
        }


        bingoN = 0;
        checkRow(); // 행
        checkCol(); // 열
        checkLtoR(); // 왼쪽 시작 대각선
        checkRtoL(); // 오른쪽 시작 대각선

        if(bingoN >= 3) {
          System.out.println(res);
          System.exit(0);
        }
      }
    }

  }

  private static void checkRow() {

    for (int r = 0; r < 5; r++) {
      int cnt = 0;
      for (int c = 0; c < 5; c++) {
        if(board[r][c] == 0) cnt++;
      }

      if(cnt == 5) bingoN++;

    }

  }

  private static void checkCol() {

    for (int r = 0; r < 5; r++) {

      int cnt = 0;
      for (int c = 0; c < 5; c++) {
        if(board[c][r] == 0) cnt++;
      }

      if(cnt == 5) bingoN++;

    }

  }

  private static void checkLtoR() {

    for (int i = 0; i < 5; i++) {
      if(board[i][i] != 0) return;
    }
    bingoN++;
  }

  private static void checkRtoL() {

    for (int i = 0; i < 5; i++) {
      if(board[i][5 - i - 1] != 0) return;
    }
    bingoN++;
  }

//  static boolean isVisited_L, isVisited_R;
//  public static void main(String[] args) throws IOException {
//    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    StringTokenizer st =  null;
//
//    // 빙고판 입력
//    board = new int[5][5];
//    for (int r = 0; r < 5; r++) {
//      st = new StringTokenizer(br.readLine());
//      for (int c = 0; c < 5; c++) {
//        board[r][c] = Integer.parseInt(st.nextToken());
//      }
//    }
//
//    // 사회자가 부를 숫자 입력
//    numbers = new int[5][5];
//    for (int r = 0; r < 5; r++) {
//      st = new StringTokenizer(br.readLine());
//      for (int c = 0; c < 5; c++) {
//        numbers[r][c] = Integer.parseInt(st.nextToken());
//      }
//    }
//
//    isVisited_L = false;
//    isVisited_R = false;
//    checkR = new boolean[5];
//    checkC = new boolean[5];
//    int res = 0;
//    for (int i = 0; i < 5; i++) {
//      for (int j = 0; j < 5; j++) {
//        int n = numbers[i][j];
//        res++;
//
//        for (int r = 0; r < 5; r++) {
//          for (int c = 0; c < 5; c++) {
//            if(n == board[r][c]) board[r][c] =0;
//          }
//        }
//
//
//          bingoN = 0;
//          checkRow(); // 행
//          checkCol(); // 열
//          checkLtoR(); // 왼쪽 시작 대각선
//          checkRtoL(); // 오른쪽 시작 대각선
//
//        if(bingoN >= 3) {
//          System.out.println(res);
//          System.exit(0);
//        }
//      }
//    }
//
//  }
//
//  static boolean checkR[];
//  private static void checkRow() {
//
//    for (int r = 0; r < 5; r++) {
//      int cnt = 0;
//      for (int c = 0; c < 5; c++) {
//        if(board[r][c] == 0) cnt++;
//      }
//
//      if(cnt == 5 && checkR[r] == false) {
//        bingoN++;
//        checkR[r] = true;
//      }
//
//
//    }
//
//  }
//
//  static boolean checkC[];
//  private static void checkCol() {
//
//    for (int r = 0; r < 5; r++) {
//
//      int cnt = 0;
//      for (int c = 0; c < 5; c++) {
//        if(board[c][r] == 0) cnt++;
//      }
//
//      if(cnt == 5 && checkC[r] == false) {
//        bingoN++;
//        checkC[r] = true;
//      }
//
//
//    }
//
//  }
//
//  private static void checkLtoR() {
//
//    for (int i = 0; i < 5; i++) {
//      if(board[i][i] != 0) return;
//    }
//    bingoN++;
//    isVisited_L = true;
//  }
//
//  private static void checkRtoL() {
//
//    for (int i = 0; i < 5; i++) {
//      if(board[i][5 - i - 1] != 0) return;
//    }
//    bingoN++;
//    isVisited_R = true;
//  }

}
