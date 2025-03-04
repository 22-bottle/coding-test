import java.io.*;
import java.util.*;

class Solution {
    static char[][] map;
    static Map<Character, Integer> m = new HashMap<>() {{
        put('N', 0); put('S', 1); put('W', 2); put('E', 3);
    }};
    static int[] dr = new int[] {-1, 1, 0, 0};
    static int[] dc = new int[] {0, 0, -1, 1};
    
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[] {0, 0};
        map = new char[park.length][park[0].length()];
        for (int i = 0; i < park.length; i++) {
            String p = park[i];
            for (int j = 0; j < p.length(); j++) {
                map[i][j] = p.charAt(j);
                if (map[i][j] == 'S') {
                    answer[0] = i; answer[1] = j;
                }
            }
        }
        
        for (String route : routes) {
            answer = go(answer, route);
        }
        return answer;
    }
    
    public int[] go(int[] loc, String route) {
        int d = m.get(route.charAt(0));
        int dist = Integer.valueOf(route.charAt(2) - '0');
        int r = loc[0], c = loc[1];
        for (int i = 0; i < dist; i++) {
            r += dr[d];
            c += dc[d];
            if (!canGo(r, c)) return loc;
        }
        return new int[] {r, c};
    }
    
    public boolean canGo(int r, int c) {
        if (r < 0 || r >= map.length || c < 0 || c >= map[0].length) return false;
        return map[r][c] != 'X';
    }
}