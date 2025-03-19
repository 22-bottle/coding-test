import java.io.*;
import java.util.*;

class Solution {
    public int solution(int n) {
        String s = Integer.toBinaryString(n);
        int num = count(s);
        while (true) {
            s = Integer.toBinaryString(++n);
            if (count(s) == num) break;
        }
        return n;
    }
    
    public int count(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '1') count++;
        }
        return count;
    }
}