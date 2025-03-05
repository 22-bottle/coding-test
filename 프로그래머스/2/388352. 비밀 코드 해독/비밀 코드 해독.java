import java.io.*;
import java.util.*;

class Solution {
    int[][] Q;
    int[] ANS;
    int N, answer = 0;
    int[] selected = new int[5];
    
    public int solution(int n, int[][] q, int[] ans) {
        N = n; Q = q; ANS = ans;
        select(0, 1);
        return answer;
    }
    
    public void select(int idx, int start) {
        if (idx >= 5) {
            check();
            return;
        }
        for (int i = start; i <= N; i++) {
            selected[idx] = i;
            select(idx + 1, i + 1);
        }
    }
    
    public void check() {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < 5; i++) {
            set.add(selected[i]);
        }
        
        for (int i = 0; i < Q.length; i++) {
            int count = ANS[i];
            for (int j = 0; j < 5; j++) {
                if (set.contains(Q[i][j])) {
                    if (--count < 0)
                        return;
                }
            }
            if (count != 0) return;
        }
        answer++;
    }
}