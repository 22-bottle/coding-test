import java.io.*;
import java.util.*;

class Solution {
    static long[] count;
    
    public long solution(int n) {
        count = new long[n + 1];
        count[1] = 1;
        if (n > 1) count[2] = 2;
        for (int i = 3; i <= n; i++) {
            count[i] = (count[i - 1] + count[i - 2]) % 1234567;
        }
        return count[n] % 1234567;
    }
}