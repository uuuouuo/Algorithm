package 백준;

import java.io.*;
import java.util.*;

public class bj14426 { // 접두사 찾기

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        TrieNode trie = new TrieNode();
        for (int i = 0; i < n; i++) {
            trie.insert(br.readLine());
        }

        int answer = 0;
        for (int i = 0; i < m; i++) {
            if (trie.contains(br.readLine()))
                answer++;
        }

        System.out.println(answer);
    }

    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        boolean last;

        TrieNode() {
        }

        public void insert(String str) {
            TrieNode trieNode = this;

            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);

                trieNode.children.putIfAbsent(c, new TrieNode());

                trieNode = trieNode.children.get(c);
                if (i == str.length() - 1) {
                    trieNode.last = true;
                    return;
                }
            }
        }

        public boolean contains(String str) {
            TrieNode trieNode = this;

            for (int i = 0; i < str.length(); i++) {
                TrieNode tmpNode = trieNode.children.get(str.charAt(i));

                if (tmpNode == null)
                    return false;

                trieNode = tmpNode;
            }
            return true;
        }
    }
}
