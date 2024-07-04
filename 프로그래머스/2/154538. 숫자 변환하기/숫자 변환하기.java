import java.io.*;
import java.util.*;

class Solution {
    static final int MAX = 1000000;
    static int mem[];
    
    public int solution(int x, int y, int n) {
        mem = new int[y + 1];
        Arrays.fill(mem, MAX);
        mem[x] = 0;
        
        for (int i = x; i <= y; i++) {
            if (i > n) mem[i] = Integer.min(mem[i], mem[i - n] + 1);
            if (i % 2 == 0) mem[i] = Integer.min(mem[i], mem[i / 2] + 1);
            if (i % 3 == 0) mem[i] = Integer.min(mem[i], mem[i / 3] + 1);
        }
        
        if (mem[y] == MAX) return -1;
        return mem[y];
    }
}