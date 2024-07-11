import java.io.*;
import java.util.*;

class Solution {
    static int[][] time = {
        { 1, 7, 6, 7, 5, 4, 5, 3, 2, 3 },
        { 7, 1, 2, 4, 2, 3, 5, 4, 5, 6 },
        { 6, 2, 1, 2, 3, 2, 3, 5, 4, 5 },
        { 7, 4, 2, 1, 5, 3, 2, 6, 5, 4 },
        { 5, 2, 3, 5, 1, 2, 4, 2, 3, 5 },
        { 4, 3, 2, 3, 2, 1, 2, 3, 2, 3 },
        { 5, 5, 3, 2, 4, 2, 1, 5, 3, 2 },
        { 3, 4, 5, 6, 2, 3, 5, 1, 2, 4 },
        { 2, 5, 4, 5, 3, 2, 3, 2, 1, 2 },
        { 3, 6, 5, 4, 5, 3, 2, 4, 2, 1 }};
    static String input;
    static int[][][] mem;
    
    public int solution(String numbers) {
        input = numbers;
        mem = new int[input.length()][10][10];
        for (int i = 0; i < input.length(); i++) {
            for (int j = 0; j < 10; j++) {
                Arrays.fill(mem[i][j], -1);
            }
        }
        return choose(0, 4, 6);
    }
    
    public int choose(int depth, int left, int right) {
        if (depth == input.length()) {
            return 0;
        }
        if (mem[depth][left][right] != -1) return mem[depth][left][right];
        int num = input.charAt(depth) - '0';
        int result = Integer.MAX_VALUE;
        if (right != num) result = Integer.min(result, choose(depth + 1, num, right) + time[left][num]);
        if (left != num) result = Integer.min(result, choose(depth + 1, left, num) + time[right][num]);
        return mem[depth][left][right] = result;
    }
}