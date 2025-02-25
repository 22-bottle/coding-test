import java.io.*;
import java.util.*;

class Solution {
    static int one = 0, zero = 0;
    public int[] solution(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') one++;
            else zero++;
        }
        
        int count = 0;
        while (one > 1) {
            one = trans();
            count++;
        }
        
        return new int[] {count + 1, zero};
    }
    
    public int trans() {
        int count = 0;
        int idx = 0;
        while (one >= (1 << idx)) {
            if ((one & (1 << idx)) != 0) count++;
            else zero++;
            idx++;
        }
        return count;
    }
}