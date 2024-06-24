import java.io.*;
import java.util.*;

class Solution {
    static List<Integer>[] adjList;
    static int cost[];
    static Queue<Integer> q = new ArrayDeque<>();
    
    public int solution(int n, int[][] edge) {
        adjList = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            adjList[i] = new ArrayList<>();
        }
        cost = new int[n + 1];
        
        for (int i = 0; i < edge.length; i++) {
            int from = edge[i][0];
            int to = edge[i][1];
            adjList[from].add(to);
            adjList[to].add(from);
        }
        
        int max = 0;
        q.offer(1);
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (Integer i : adjList[cur]) {
                if (i != 1 && cost[i] == 0) {
                    cost[i] = cost[cur] + 1;
                    q.offer(i);
                    max = Integer.max(max, cost[i]);
                }
            }
        }
        
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (cost[i] == max) {
                count++;
            }
        }
        return count;
    }
}