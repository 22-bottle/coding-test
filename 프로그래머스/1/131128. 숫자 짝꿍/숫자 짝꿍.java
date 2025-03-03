import java.io.*;
import java.util.*;

class Solution {
    static int[] count1 = new int[10];
    static int[] count2 = new int[10];
    
    public String solution(String X, String Y) {
        for (int i = 0; i < X.length(); i++) {
            count1[Integer.valueOf(X.charAt(i) - '0')]++;
        }
        for (int i = 0; i < Y.length(); i++) {
            count2[Integer.valueOf(Y.charAt(i) - '0')]++;
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 9; i >= 0; i--) {
            for (int j = 0; j < Integer.min(count1[i], count2[i]); j++) {
                sb.append(i);
            }
        }
        String answer = sb.toString();
        if (answer.length() == 0) return "-1";
        if (answer.charAt(0) == '0') return "0";
        return sb.toString();
    }
}