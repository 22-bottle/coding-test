import java.io.*;
import java.util.*;

class Solution {
    class Info {
        String word;
        int count;
        
        public Info(String word, int count) {
            this.word = word;
            this.count = count;
        }
    }
    
    static Queue<Info> q = new ArrayDeque<>();
    static boolean[] visited;
    
    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        Info first = new Info(begin, 0);
        q.offer(first);
        
        while (!q.isEmpty()) {
            Info cur = q.poll();
            if (cur.word.equals(target)) return cur.count;
            for (int i = 0; i < words.length; i++) {
                if (!visited[i] && canConvert(cur.word, words[i])) {
                    q.offer(new Info(words[i], cur.count + 1));
                    visited[i] = true;
                }
            }
        }
        return 0;
    }
    
    public boolean canConvert(String from, String to) {
        int count = 0;
        for (int i = 0; i < from.length(); i++) {
            if (from.charAt(i) != to.charAt(i)) {
                count++;
            }
        }
        if (count != 1) return false;
        else return true;
    }
}