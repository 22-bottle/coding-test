import java.io.*;
import java.util.*;

class Solution {
    int solution(int[][] land) {
        int[][] mem = new int[land.length][4];
        for (int i = 0; i < 4; i++) {
            mem[0][i] = land[0][i];
        }
        for (int i = 1; i < land.length; i++) {
            for (int j = 0; j < 4; j++) {
                int max = 0;
                for (int k = 0; k < 4; k++) {
                    if (j == k) continue;
                    max = Integer.max(max, mem[i - 1][k]);
                }
                mem[i][j] = land[i][j] + max;
            }
        }
        int answer = 0;
        for (int i = 0; i < 4; i++) {
            answer = Integer.max(answer, mem[land.length - 1][i]);
        }
        return answer;
    }
}