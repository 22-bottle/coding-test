import java.io.*;
import java.util.*;

class Solution {
    static int[][] mat;
    static int[] distance;
    static PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
        return o1[1] - o2[1];
    });
    
    public int solution(int N, int[][] road, int K) {
        mat = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            Arrays.fill(mat[i], Integer.MAX_VALUE);
        }
        distance = new int[N + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        for (int[] r : road) {
            mat[r[0]][r[1]] = Integer.min(mat[r[0]][r[1]], r[2]);
            mat[r[1]][r[0]] = Integer.min(mat[r[1]][r[0]], r[2]);
        }
        
        pq.offer(new int[] {1, 0});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int L = cur[0];
            int W = cur[1];
            if (W >= distance[L]) continue;
            distance[L] = W;
            
            for (int i = 1; i <= N; i++) {
                if (mat[L][i] == Integer.MAX_VALUE) continue;
                if (W + mat[L][i] < distance[i]) {
                    pq.offer(new int[] {i, W + mat[L][i]});
                }
            }
        }
        
        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (distance[i] <= K) count++;
        }
        return count;
    }
}