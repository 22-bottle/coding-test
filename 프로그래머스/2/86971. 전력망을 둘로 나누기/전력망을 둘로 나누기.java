import java.io.*;
import java.util.*;

class Solution {
    static int N;
    static boolean[][] mat;
    
    public int solution(int n, int[][] wires) {
        N = n;
        mat = new boolean[n + 1][n + 1];
        for (int[] wire : wires) {
            mat[wire[0]][wire[1]] = true;
            mat[wire[1]][wire[0]] = true;
        }
        
        int answer = Integer.MAX_VALUE;
        for (int[] wire : wires) {
            mat[wire[0]][wire[1]] = false;
            mat[wire[1]][wire[0]] = false;
            answer = Integer.min(answer, Math.abs(count(wire[0]) - count(wire[1])));
            mat[wire[0]][wire[1]] = true;
            mat[wire[1]][wire[0]] = true;
        }
        return answer;
    }
    
    public int count(int start) {
        Queue<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[N + 1];
        q.offer(start);
        visited[start] = true;
        
        int count = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();
            count++;
            for (int i = 1; i <= N; i++) {
                if (!visited[i] && mat[cur][i]) {
                    q.offer(i);
                    visited[i] = true;
                }
            }
        }
        return count;
    }
}