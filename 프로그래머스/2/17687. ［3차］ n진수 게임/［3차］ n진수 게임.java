import java.io.*;
import java.util.*;

class Solution {
    static String[] mem = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"};
    static StringBuilder sb = new StringBuilder();
    
    public String solution(int n, int t, int m, int p) {
        int num = 0;
        while (sb.length() < (m * t)) {
            String conNum = convert(num, n);
            sb.append(conNum);
            num++;
        }
        StringBuilder answer = new StringBuilder();
        for (int k = p - 1; t > 0; k += m) {
            answer.append(sb.charAt(k));
            t--;
        }
        return answer.toString();
    }
    
    public String convert(int num, int n) {
        if (num == 0) return "0";
        StringBuilder sb2 = new StringBuilder();
        while (num > 0) {
            int rest = num % n;
            sb2.append(mem[rest]);
            num /= n;
        }
        return sb2.reverse().toString();
    }
}