import java.io.*;
import java.util.*;

class Solution {
    static int answer = 0;
    static int[] queens;
    static boolean[] selected;
    
    public int solution(int n) {
        queens = new int[n];
        selected = new boolean[n];
        go(0);
        return answer;
    }
    
    public void go(int n) {
        if (n >= queens.length) {
            answer++;
            return;
        }
        for (int i = 0; i < queens.length; i++) {
            if (selected[i]) continue;
            if (!check(n, i)) continue;
            queens[n] = i;
            selected[i] = true;
            go(n + 1);
            selected[i] = false;
        }
    }
    
    public boolean check(int r, int c) {
        for (int i = 0; i < r; i++) {
            if (Math.abs(i - r) == Math.abs(queens[i] - c))
                return false;
        }
        return true;
    }
}