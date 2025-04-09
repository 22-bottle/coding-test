import java.io.*;
import java.util.*;

class Solution {
    static int[][] mem;
    
    public int solution(int n, int[][] results) {
        mem = new int[n + 1][n + 1];
        for (int[] result : results) {
            mem[result[0]][result[1]] = 1;
        }
        
        for (int mid = 1; mid <= n; mid++) {
            for (int i = 1; i <= n; i++) {
                if (i == mid) continue;
                for (int j = 1; j <= n; j++) {
                    if (j == i || j == mid) continue;
                    if (mem[i][mid] == 1 && mem[mid][j] == 1)
                        mem[i][j] = 1;
                }
            }
        }
        
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            int count = 0;
            for (int j = 1; j <= n; j++) {
                if (mem[i][j] == 1) count++;
                if (mem[j][i] == 1) count++;
            }
            if (count == n - 1) answer++;
        }
        return answer;
    }
}