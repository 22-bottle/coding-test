import java.io.*;
import java.util.*;

class Solution {
    boolean[] skips = new boolean[26];
    Set<Character> set = new HashSet<>();
    Map<Character, Character> map = new HashMap<>();
    
    public String solution(String s, String skip, int index) {
        for (int i = 0; i < skip.length(); i++) {
            set.add(skip.charAt(i));
        }
        
        for (char c = 'a'; c <= 'z'; c++) {
            int count = 0, offset = 0;
            while (count < index) {
                offset++;
                if (c + offset > 'z') offset -= 26;
                if (!set.contains((char)(c + offset))) count++;
            }
            map.put(c, (char)(c + offset));
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            sb.append(map.get(s.charAt(i)));
        }
        return sb.toString();
    }
}