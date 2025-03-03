import java.io.*;
import java.util.*;

class Solution {
    static int[] min = new int[26];
    
    public int[] solution(String[] keymap, String[] targets) {
        Arrays.fill(min, Integer.MAX_VALUE);
        for (String key : keymap) {
            for (int i = 0; i < key.length(); i++) {
                char c = key.charAt(i);
                min[c - 'A'] = Integer.min(min[c - 'A'], i + 1);
            }
        }
        
        int[] answer = new int[targets.length];
        for (int i = 0; i < targets.length; i++) {
            String target = targets[i];
            int sum = 0;
            for (int j = 0; j < target.length(); j++) {
                char c = target.charAt(j);
                if (min[c - 'A'] == Integer.MAX_VALUE) {
                    sum = Integer.MAX_VALUE;
                    break;
                }
                sum += min[c - 'A'];
            }
            answer[i] = sum == Integer.MAX_VALUE ? -1 : sum;
        }
        return answer;
    }
}