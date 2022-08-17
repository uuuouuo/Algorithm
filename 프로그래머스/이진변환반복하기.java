package 프로그래머스;

import java.util.*;
class 이진변환반복하기 {
    public int[] solution(String s) {

        long length = s.length();
        int turn = 0;
        int zero = 0;
        
        while(!s.equals("1")) {
            // 회차
            turn++;
            // 0 제거
            s = s.replace("0", "");
   
            // 0의 개수
            zero += length - s.length();
     
            // s 길이 이진 변환
            length = s.length();        
            s = Long.toBinaryString(length);
            
            length = s.length();

        }
        
        
        return new int[]{turn, zero};
    }
}