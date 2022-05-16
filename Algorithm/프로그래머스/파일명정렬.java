import java.util.*;
class Solution {
    public String[] solution(String[] files) {
        // 1. 헤드 사전순 Object.compareTo(_) -> 모두 소문자로 치환 toLowerCase()
        // 2. 헤드가 같을 경우 숫자 사전순 -> int로 치환하고 비교 / 5자 이하 체크
        // 3. 헤드, 숫자 모두 같을 경우 -> files의 index 번호로 따지기
        Arrays.sort(files, new Comparator<String>() {
            @Override
            public int compare(String f1, String f2) {
                String h1 = f1.split("[0-9]")[0];
                String h2 = f2.split("[0-9]")[0];

                int result = h1.toLowerCase().compareTo(h2.toLowerCase());

                if(result == 0) {
                    result = getNum(f1, h1) - getNum(f2, h2);                    

                }
                return result;
            }

        });
        return files;
    }

    static int getNum(String file, String head) {

        file = file.replace(head, "");
        String result = "";

        for(char c : file.toCharArray()) {

            // 숫자 확인 & 길이 확인
            if(!Character.isDigit(c) 
               || result.length() > 5) break;
            result += c;
        }

        return Integer.parseInt(result);
    }
}