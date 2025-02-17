import java.io.*;
import java.util.*;

class Solution {
    public int solution(int n) {
        int start = 1;
        while (start <= n) {
            start *= 3;
        }
        start /= 3;
        
        String s = "";
        while (n > 0) {
            s += n / start;
            n -= start * (n / start);
            start /= 3;
        }
        
        int sum = 0;
        int cur = 1;
        for (int i = 0; i < s.length(); i++) {
            sum += cur * (s.charAt(i) - '0');
            cur *= 3;
        }
        return sum;
    }
}