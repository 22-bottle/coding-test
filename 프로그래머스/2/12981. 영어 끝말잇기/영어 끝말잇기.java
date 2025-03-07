import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        Set<String> set = new HashSet<>();
        
        char last = words[0].charAt(0);
        for (int i = 0; i < words.length; i++) {
            if (words[i].charAt(0) != last || set.contains(words[i])) {
                return new int[] {i % n + 1, i / n + 1};
            }
            last = words[i].charAt(words[i].length() - 1);
            set.add(words[i]);
        }
        return new int[] {0, 0};
    }
}