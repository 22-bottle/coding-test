import java.io.*;
import java.util.*;

class Solution {
    static int[] dr = new int[] {-1, 1, 0, 0};
    static int[] dc = new int[] {0, 0, -1, 1};
    static char[][] room;
    static Queue<int[]> q;
    static Map<Integer, Integer> map;
    
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        for (int i = 0; i < places.length; i++) {
            init(places[i]);
            if (check(places[i]))
                answer[i] = 1;
        }
        return answer;
    }
    
    public void init(String[] place) {
        room = new char[5][5];
        q = new ArrayDeque<>();
        int count = 0;
        map = new HashMap<>();
        for (int i = 0; i < 5; i++) {
            room[i] = place[i].toCharArray();
            for (int j = 0; j < 5; j++) {
                if (room[i][j] == 'P') {
                    q.offer(new int[] {i, j, 0, count});
                    map.put(count++, i * 10 + j);
                }
            }
        }
    }
    
    public boolean check(String[] place) {
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (cur[2] == 2) continue;
            for (int d = 0; d < 4; d++) {
                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d];
                if (!canMove(nr, nc)) continue;
                if (room[nr][nc] == 'P' && map.get(cur[3]) != nr * 10 + nc) return false;
                q.offer(new int[] {nr, nc, cur[2] + 1, cur[3]});
            }
        }
        return true;
    }
    
    public boolean canMove(int r, int c) {
        if (r < 0 || r >= 5 || c < 0 || c >= 5) return false;
        return room[r][c] != 'X';
    }
}