package 프로그래머스;

import java.util.*;
class 구명보트 {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        // for(int p : people)
        //     System.out.println(p);
        
        int answer = 0;
        int min = 0;
        int max = people.length-1;
        while(min <= max) {
            // System.out.println(min+" "+max);
            if(people[min]+people[max] <= limit) {
                answer++;
                min++;
                max--;
            } else {
                answer++;
                max--;
            }
                
        }
        
        return answer;
    }
}