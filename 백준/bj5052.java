package 백준;

import java.io.*;
import java.util.*;

public class bj5052 {

    // 트라이 노드
    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>(); // 자손 노드
        boolean last; // 종료 노드 확인

        // 생성자
        TrieNode() {}

        // 노드 저장 함수 -> 초기 세팅
        public void insert(String str) {
            TrieNode trieNode = this;

            for(int i=0; i<str.length(); i++) {
                char c = str.charAt(i);

                // if(!node.children.containsKey(c)) node.children.put(c, new TrieNode());
                trieNode.children.putIfAbsent(c, new TrieNode()); // 자손노드 중 c 없으면 추가

                trieNode = trieNode.children.get(c);
                if (i == str.length()-1) { // 마지막 글자는 종료노드 표시
                    trieNode.last = true;
                    return;
                }
            }
        }

        // 포함되어 있는지 확인하는 함수
        public boolean contains(String str) {
            TrieNode trieNode = this;

            for(int i=0; i<str.length(); i++) {
                TrieNode tempNode = trieNode.children.get(str.charAt(i));

                if(tempNode == null) return false; // 해당 번호가 없으면 접두사 아님
                trieNode = tempNode;
            }

            // 해당 번호가 종료 문자 있으면서, 자기 자신 제외 (자손노드 없으면 해당 종료노드는 자기자신)
            if(trieNode.last && trieNode.children.isEmpty()) return false;

            return true;
        }

    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            TrieNode trie = new TrieNode(); // 트라이 노드 생성
            boolean isExist = false; // 겹치는게 있으면 true -> 일관성 없는 목록

            Set<String> contacts = new HashSet<>();
            for(int i=0; i<N; i++) {
                String contact = br.readLine();
                trie.insert(contact); // 트라이 노드에 삽입
                contacts.add(contact); // 전화번호부 저장
            }

            for(String c : contacts) {
                if(trie.contains(c)) {
                    isExist = true;
                    break;
                }
            }
            System.out.println(isExist ? "NO" : "YES");
        }
    }

}
