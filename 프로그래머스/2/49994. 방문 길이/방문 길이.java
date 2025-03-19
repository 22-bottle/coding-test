import java.io.*;
import java.util.*;

class Solution {
    static boolean[][][] visited = new boolean[11][11][4];
    static int r = 5, c = 5;
    static Map<Character, Integer> map = new HashMap<>() {{
        put('U', 0);
        put('D', 1);
        put('R', 2);
        put('L', 3);
    }};
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    
    public int solution(String dirs) {
        int answer = 0;
        for (int i = 0; i < dirs.length(); i++) {
            int dir = map.get(dirs.charAt(i));
            int nr = r + dr[dir];
            int nc = c + dc[dir];
            
            if (canGo(nr, nc)) {
                if (!visited[r][c][dir]) {
                    visited[r][c][dir] = true;
                    int opposite = dir % 2 == 0 ? dir + 1 : dir - 1;
                    visited[nr][nc][opposite] = true;
                    answer++;
                }
                r = nr; c = nc;
            }
        }
        return answer;
    }
    
    public boolean canGo(int r, int c) {
        if (r < 0 || r >= 11 || c < 0 || c >= 11) return false;
        return true;
    }
}