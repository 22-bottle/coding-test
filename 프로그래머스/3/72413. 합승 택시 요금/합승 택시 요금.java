import java.io.*;
import java.util.*;

class Solution {
    static int INF = 100_000_000;
    static int[][] dist;
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        dist = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }
        
        for (int[] fare : fares) {
            dist[fare[0]][fare[1]] = fare[2];
            dist[fare[1]][fare[0]] = fare[2];
        }
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (j == i) continue;
                for (int k = 1; k <= n; k++) {
                    if (k == i || k == j) continue;
                    dist[j][k] = Integer.min(dist[j][k], dist[j][i] + dist[i][k]);
                }
            }
        }
        
        pq.offer(dist[s][a] + dist[s][b]);
        for (int i = 1; i <= n; i++) {
            pq.offer(dist[s][i] + dist[i][a] + dist[i][b]);
        }
        return pq.poll();
    }
}