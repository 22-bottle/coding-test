import java.io.*;
import java.util.*;

class Solution {
    static PriorityQueue<String>[] pqs = new PriorityQueue[26];
    
    public String[] solution(String[] strings, int n) {
        for (int i = 0; i < 26; i++) {
            pqs[i] = new PriorityQueue<>();
        }
        
        for (String s : strings) {
            int c = s.charAt(n) - 'a';
            pqs[c].offer(s);
        }
        
        String[] answer = new String[strings.length];
        int idx = 0;
        for (int i = 0; i < 26; i++) {
            while (!pqs[i].isEmpty()) {
                answer[idx++] = pqs[i].poll();
            }
        }
        return answer;
    }
}