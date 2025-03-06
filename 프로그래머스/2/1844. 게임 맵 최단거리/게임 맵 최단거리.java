import java.io.*;
import java.util.*;

class Solution {
    static int[] dr = new int[] {-1, 1, 0, 0};
    static int[] dc = new int[] {0, 0, -1, 1};
    static int[][] min;
    static int n, m;
    
    public int solution(int[][] maps) {
        n = maps.length; m = maps[0].length;
        min = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(min[i], Integer.MAX_VALUE);
        }
        
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {0, 0, 1});
        min[0][0] = 0;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0]; int c = cur[1]; int move = cur[2];
            if (r == n - 1 && c == m - 1) continue;
            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                int nmove = move + 1;
                if (!canGo(maps, nr, nc, nmove)) continue;
                q.offer(new int[] {nr, nc, nmove});
                min[nr][nc] = nmove;
            }
        }
        return min[n - 1][m - 1] != Integer.MAX_VALUE ? min[n - 1][m - 1] : -1;
    }
    
    public boolean canGo(int[][] maps, int r, int c, int move) {
        if (r < 0 || r >= n || c < 0 || c >= m) return false;
        if (maps[r][c] == 0 || min[r][c] <= move) return false;
        return true;
    }
}