import java.io.*;
import java.util.*;

class Solution {
    static int[][] mem;
    
    public int solution(int[][] triangle) {
        mem = new int[triangle.length][];
        for (int i = 0; i < triangle.length; i++) {
            mem[i] = new int[i + 1];
        }
        mem[0][0] = triangle[0][0];
        for (int i = 1; i < mem.length; i++) {
            for (int j = 0; j < mem[i].length; j++) {
                int max = -1;
                if (j > 0) max = Integer.max(max, mem[i - 1][j - 1]);
                if (j < mem[i - 1].length) max = Integer.max(max, mem[i - 1][j]);
                mem[i][j] = max + triangle[i][j];
            }
        }
        int answer = -1;
        for (int i = 0; i < mem.length; i++) {
            answer = Integer.max(answer, mem[mem.length - 1][i]);
        }
        return answer;
    }
}