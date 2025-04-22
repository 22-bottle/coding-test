import java.io.*;
import java.util.*;

class Solution {
    static int NUM = 1_000_000_007;
    static int[] mem;
    
    public int solution(int n) {
        mem = new int[n + 1];
        mem[1] = 1;
        mem[2] = 2;
        for (int i = 3; i <= n; i++) {
            mem[i] = (mem[i - 1] + mem[i - 2]) % NUM;
        }
        return mem[n] % NUM;
    }
}