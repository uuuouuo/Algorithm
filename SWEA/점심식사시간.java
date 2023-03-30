package SWEA;

import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class 점심식사시간 {
    // 사람 1, 계단 길이 2이상
    // 가장 가까운 계단 찾기 => 계단에 사람들 담기, 몇분 걸리는지 담기

    // 입력 -> 계단 위치, 사람 위치 저장
    // 가까운 계단 찾기
    // 계단에 사람들, 시간 저장 -> 리스트 배열 생성

    // 계단별로 확인
    // 해당 계단의 사람 수만큼 체크배열 생성 -> 이동 완료 체크 or list에서 제거
    // 크기 30인 배열 생성 -> 사람 번호, 남은 계단 시간 저장
    // 큐를 이용하여
    // 0 ~ 30분 확인

    static List<Point> stairs, people;
    static List<Info> infos[];
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {

        }
    }

    static class Point {
        int r, c;
        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static class Info {
        int person, time;
        public Info(int person, int time) {
            this.person = person;
            this.time = time;
        }
    }
}
