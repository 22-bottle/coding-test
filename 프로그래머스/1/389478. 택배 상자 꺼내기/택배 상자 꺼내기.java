import java.io.*;
import java.util.*;

class Solution {
    static int[][] map;
    static int r, c;
    
    public int solution(int n, int w, int num) {
        map = new int[n / w + 1][w];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < w; j++) {
                int cur = i * w + j + 1;
                if (i % 2 == 0) {
                    map[i][j] = cur;
                    if (cur == num) {
                        r = i; c = j;
                    }
                } else {
                    map[i][w - j - 1] = cur;
                    if (cur == num) {
                        r = i; c = w - j - 1;
                    }
                }
            }
        }
        
        int answer = 0;
        while (r < map.length) {
            if (map[r][c] > n) break;
            answer++;
            r++;
        }
        return answer;
    }
}