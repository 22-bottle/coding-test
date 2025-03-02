import java.io.*;
import java.util.*;

class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        for (String b : babbling) {
            int type = 0;
            while (b.length() > 0) {
                int[] info = check(b);
                int n = info[0];
                if (n == 0) break;
                if (type == info[1]) break;
                type = info[1];
                b = b.substring(n, b.length());
            }
            if (b.length() == 0) answer++;
        }
        return answer;
    }
    
    public int[] check(String b) {
        if (b.length() < 2) return new int[] {0, 0};
        
        if (b.charAt(0) == 'y' && b.charAt(1) == 'e') return new int[] {2, 1};
        if (b.charAt(0) == 'm' && b.charAt(1) == 'a') return new int[] {2, 2};
        
        if (b.length() >= 3) {
            if (b.charAt(0) == 'a' && b.charAt(1) == 'y' && b.charAt(2) == 'a') return new int[] {3, 3};
            if (b.charAt(0) == 'w' && b.charAt(1) == 'o' && b.charAt(2) == 'o') return new int[] {3, 4};
        }
        return new int[] {0, 0};
    }
}