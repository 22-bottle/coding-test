import java.io.*;
import java.util.*;

class Solution {
    static int[] dr = new int[] {-1, 1, 0, 0};
    static int[] dc = new int[] {0, 0, -1, 1};
    static int[][] landNum;
    static boolean[][] visited;
    static int num = 1;
    static Map<Integer, Integer> map = new HashMap<>();
    
    public int solution(int[][] land) {
        landNum = new int[land.length][land[0].length];
        visited = new boolean[land.length][land[0].length];
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[0].length; j++) {
                if (land[i][j] == 1 && !visited[i][j]) {
                    bfs(land, i, j);
                    num++;
                }
            }
        }
        
        int oil = 0;
        for (int i = 0; i < land[0].length; i++) {
            oil = Integer.max(oil, score(i));
        }
        return oil;
    }
    
    public void bfs(int[][] land, int r, int c) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {r, c});
        landNum[r][c] = num;
        visited[r][c] = true;
        int count = 1;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int d = 0; d < 4; d++) {
                int nextR = cur[0] + dr[d];
                int nextC = cur[1] + dc[d];
                if (canMove(land, nextR, nextC)) {
                    q.offer(new int[] {nextR, nextC});
                    landNum[nextR][nextC] = num;
                    visited[nextR][nextC] = true;
                    count++;
                }
            }
        }
        map.put(num, count);
    }
    
    public boolean canMove(int[][] land, int r, int c) {
        if (r < 0 || c < 0 || r >= land.length || c >= land[0].length)
            return false;
        if (visited[r][c]) return false;
        return land[r][c] == 1;
    }
    
    public int score(int n) {
        boolean[] contain = new boolean[num];
        for (int i = 0; i < landNum.length; i++) {
            contain[landNum[i][n]] = true;
        }
        int score = 0;
        for (int i = 1; i < num; i++) {
            if (contain[i]) score += map.get(i);
        }
        return score;
    }
}