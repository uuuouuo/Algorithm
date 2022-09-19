import java.util.*;
class Solution {
    public int solution(String skill, String[] skill_trees) {
        // map으로 스킬 순서 등록 -> 개수 세기
        // containsKey -> 있으면 cur(1 부터 시작)으로 현재 단계 맞는지 확인

        HashMap<Character, Integer> map = new HashMap<>();

        int n = skill.length();
        for(int i = 0; i < n; i++) {
            map.put(skill.charAt(i), i+1);
            // System.out.println(skill.charAt(i));
        }

        int answer = 0;
        int m = skill_trees.length;
        l: for(int i = 0; i < m; i++) {
            int o = skill_trees[i].length();
            String sTree = skill_trees[i]; // 스킬트리
            int step = 1;
            for(int j = 0; j < o; j++) {
                char cur = sTree.charAt(j);
                if(map.containsKey(cur)) {
                    if(map.get(cur) != step) continue l;
                    step++;
                }
            }
            answer++;
        }
        return answer;
    }
}