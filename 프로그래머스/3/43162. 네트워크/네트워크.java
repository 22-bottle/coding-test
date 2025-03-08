import java.io.*;
import java.util.*;

class Solution {
    static boolean[] selected;
    static Queue<Integer> q;
    static List<Integer>[] adjList;
    
    public int solution(int n, int[][] computers) {
        adjList = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                if (computers[i][j] == 0) continue;
                adjList[i].add(j);
                adjList[j].add(i);
            }
        }
        
        selected = new boolean[n];
        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (selected[i]) continue;
            answer++;
            q = new ArrayDeque<>();
            q.offer(i);
            selected[i] = true;
            while (!q.isEmpty()) {
                int cur = q.poll();
                for (int a : adjList[cur]) {
                    if (selected[a]) continue;
                    q.offer(a);
                    selected[a] = true;
                }
            }
        }
        return answer;
    }
}