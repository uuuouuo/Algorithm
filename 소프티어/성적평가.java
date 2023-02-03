package 소프티어;

import java.io.*;
import java.util.*;

public class 성적평가 {
    static StringBuilder sb = new StringBuilder();
    static int N, finalScores[];

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine()); // 대회참가 인원수

        finalScores = new int[N + 1];
        List<Node> scores;

        for(int i=0; i<3; i++) { // 세번의 대회

            scores = new ArrayList<>();

            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++) {
                int score = Integer.parseInt(st.nextToken());
                scores.add(new Node(j, score));
                finalScores[j] += score;
            }

            Collections.sort(scores); // 정렬
            getResult(scores); // 등수 구하기

        }

        // 최종점수 내림차순 정렬을 위해 list 저장
        scores = new ArrayList<>();
        for(int i=1; i<=N; i++) {
            scores.add(new Node(i, finalScores[i]));
        }

        Collections.sort(scores); // 정렬
        getResult(scores); // 등수 구하기

        System.out.println(sb.toString());
    }

    static void getResult(List<Node> scores) {

        int[] ranks = new int[N + 1];

        int curRank = 0;
        int sameN = 1;
        int preScore = 100000001;

        for(Node n : scores) {
            if(preScore == n.score) { // 이전 점수와 같을 때
                ranks[n.idx] = curRank; // 등수 그대로
                sameN++; // 같은 등수 인원 추가
            }
            else {
                if(sameN > 0) { // 앞전에 같은 등수가 있었다면
                    curRank += sameN; // 앞사람 수만큼 추가한 등수로
                    ranks[n.idx] = curRank;
                    sameN = 1; // 초기화
                }
                else {
                    ranks[n.idx] = ++curRank;
                }
                preScore = n.score; // 이전 점수로 저장
            }
        }
        System.out.println();

        getRank(ranks);
    }

    static public void getRank(int[] ranks) {
        for(int i=1; i<=N; i++) {
            sb.append(ranks[i] + " ");
        }
        sb.append("\n");
    }

    static class Node implements Comparable<Node>{
        int idx, score;

        public Node(int idx, int score) {
            this.idx = idx;
            this.score = score;
        }

        public int compareTo(Node o) {
            return o.score - this.score;
        }

    }
}
