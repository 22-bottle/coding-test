import java.io.*;
import java.util.*;

class Solution {
    static Map<String, Integer> dict = new HashMap<>();
    static List<Integer> list = new ArrayList<>();
    
    public int[] solution(String msg) {
        char c = 'A';
        for (int i = 1; i <= 26; i++) {
            dict.put(Character.toString(c++), i);
        }
        
        int maxLen = 1;
        while (msg.length() > 0) {
            int len = check(msg, maxLen);
            String target = msg.substring(0, len);
            msg = msg.substring(len);
            if (msg.length() > 0) {
                dict.put(target + String.valueOf(msg.charAt(0)), dict.size() + 1);
                maxLen = Integer.max(maxLen, target.length() + 1);
            }
            list.add(dict.get(target));
        }
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
    
    public int check(String msg, int maxLen) {
        while (maxLen > 0) {
            if (msg.length() >= maxLen && dict.containsKey(msg.substring(0, maxLen)))
                return maxLen;
            maxLen--;
        }
        return maxLen;
    }
}