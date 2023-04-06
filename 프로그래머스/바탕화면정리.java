package 프로그래머스;

public class 바탕화면정리 {
    public int[] solution(String[] wallpaper) {
        int[] answer = new int[4];
        int minR = 51, maxR = 0;
        int minC = 51, maxC = 0;

        for(int i = 0; i < wallpaper.length; i++) {
            String w = wallpaper[i];
            for(int j = 0; j < w.length(); j++) {
                if(w.charAt(j) == ('.')) continue;

                if(i < minR) {
                    answer[0] = i;
                    minR = i;
                }
                if(j < minC) {
                    answer[1] = j;
                    minC = j;
                }
                if(i+1 > maxR) {
                    answer[2] = i+1;
                    maxR = i+1;
                }
                if(j+1 > maxC) {
                    answer[3] = j+1;
                    maxC = j+1;
                }
            }
        }

        return answer;
    }
}
