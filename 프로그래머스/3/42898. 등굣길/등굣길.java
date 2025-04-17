import java.io.*;
import java.util.*;

class Solution {
    static int[][] map;
    static int[] dr = {-1, 0};
    static int[] dc = {0, -1};
    
    public int solution(int m, int n, int[][] puddles) {
        map = new int[n][m];
        map[0][0] = 1;
        for (int[] puddle : puddles) {
            map[puddle[1] - 1][puddle[0] - 1] = -1;
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == -1) continue;
                for (int d = 0; d < 2; d++) {
                    int nr = i + dr[d];
                    int nc = j + dc[d];
                    if (nr < 0 || nc < 0) continue;
                    if (map[nr][nc] == -1) continue;
                    map[i][j] = (map[i][j] + map[nr][nc]) % 1_000_000_007;
                }
            }
        }
        return map[n - 1][m - 1] % 1_000_000_007;
    }
}