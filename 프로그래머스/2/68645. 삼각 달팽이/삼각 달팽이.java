import java.io.*;
import java.util.*;

class Solution {
    static int[][] mem;
    static int[] dr = {1, 0, -1};
    static int[] dc = {0, 1, -1};
    static int r = 0, c = 0, d = 0;
    
    public int[] solution(int n) {
        int nn = (1 + n) * n / 2;
        mem = new int[n][n];
        for (int i = 1; i <= nn; i++) {
            mem[r][c] = i;
            int nr = r + dr[d];
            int nc = c + dc[d];
            if (nr < 0 || nr >= n || nc < 0 || nc >= n || mem[nr][nc] != 0)
                d = (d + 1) % 3;
            r += dr[d];
            c += dc[d];
        }
        
        int[] answer = new int[nn];
        int idx = 0;
        for (int rr = 0; rr < n; rr++) {
            for (int cc = 0; cc <= rr; cc++) {
                answer[idx++] = mem[rr][cc];
            }
        }
        return answer;
    }
}