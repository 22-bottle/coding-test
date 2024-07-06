import java.io.*;
import java.util.*;

class Solution {
    static int[][] map;
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    static Queue<int[]> q = new ArrayDeque<>();
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    
    public int[] solution(String[] maps) {
        map = new int[maps.length][maps[0].length()];
        for (int i = 0; i < maps.length; i++) {
            char[] chars = maps[i].toCharArray();
            for (int j = 0; j < chars.length; j++) {
                if (chars[j] == 'X') map[i][j] = 0;
                else map[i][j] = chars[j] - '0';
            }
        }

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == 0) continue;
                pq.offer(count(i, j));
            }
        }

        if (pq.isEmpty()) return new int[] {-1};
        int[] answer = new int[pq.size()];
        int idx = 0;
        while (!pq.isEmpty()) {
            answer[idx++] = pq.poll();
        }
        return answer;
    }
    
    public int count(int r, int c) {
        int sum = map[r][c];
        q.offer(new int[] {r, c});
        map[r][c] = 0;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int d = 0; d < 4; d++) {
                int nextR = cur[0] + dr[d];
                int nextC = cur[1] + dc[d];
                if (!canMove(nextR, nextC)) continue;
                sum += map[nextR][nextC];
                q.offer(new int[] {nextR, nextC});
                map[nextR][nextC] = 0;
            }
        }
        return sum;
    }
    
    public boolean canMove(int r, int c) {
        if (r < 0 || r >= map.length || c < 0 || c >= map[0].length) return false;
        return map[r][c] != 0;
    }
}