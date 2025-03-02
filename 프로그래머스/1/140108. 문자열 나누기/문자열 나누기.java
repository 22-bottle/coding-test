import java.io.*;
import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        while (s.length() > 0) {
            char x = s.charAt(0);
            int xc = 0, c = 0, idx = 0;
            for (; idx < s.length() - 1; idx++) {
                if (s.charAt(idx) == x) xc++;
                else c++;
                
                if (xc == c) break;
            }
            s = s.substring(idx + 1, s.length());
            answer++;
        }
        return answer;
    }
}