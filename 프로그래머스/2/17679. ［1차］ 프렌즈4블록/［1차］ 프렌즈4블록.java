import java.io.*;
import java.util.*;

class Solution {
    static char[][] map;
    static int[] dr = new int[] {0, 1, 1, 0};
    static int[] dc = new int[] {1, 0, 1, 0};
    
    public int solution(int m, int n, String[] board) {
        map = new char[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = board[i].charAt(j);
            }
        }
        
        int answer = 0;
        while (true) {
            int cur = erase();
            if (cur == 0) break;
            answer += cur;
            down();
        }
        return answer;
    }
    
    public void print() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    public int erase() {
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < map.length - 1; i++) {
            for (int j = 0; j < map[0].length - 1; j++) {
                if (map[i][j] == ' ') continue;
                if (check(i, j)) {
                    for (int d = 0; d < 4; d++) {
                        list.add(new int[] {i + dr[d], j + dc[d]});
                    }
                }
            }
        }
        
        int count = 0;
        for (int[] target : list) {
            if (map[target[0]][target[1]] == ' ') continue;
            map[target[0]][target[1]] = ' ';
            count++;
        }
        return count;
    }
    
    public boolean check(int r, int c) {
        char ch = map[r][c];
        for (int d = 0; d < 3; d++) {
            if (map[r + dr[d]][c + dc[d]] != ch)
                return false;
        }
        return true;
    }
    
    public void down() {
        for (int j = map[0].length - 1; j >= 0; j--) {
            for (int i = map.length - 2; i >= 0; i--) {
                int r = i + 1;
                while (r < map.length && map[r][j] == ' ') {
                    r++;
                }
                if (r == i + 1) continue;
                map[r - 1][j] = map[i][j];
                map[i][j] = ' ';
            }
        }
    }
}