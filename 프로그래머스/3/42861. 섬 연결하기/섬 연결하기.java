import java.io.*;
import java.util.*;

class Solution {
    class Edge {
        int from, to, weight;
        
        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }
    
    static int[] parents;
    static Edge[] edgeList;
    
    public int solution(int n, int[][] costs) {
        initSet(n);
        edgeList = new Edge[costs.length];
        for (int i = 0; i < costs.length; i++) {
            edgeList[i] = (new Edge(costs[i][0], costs[i][1], costs[i][2]));
        }
        Arrays.sort(edgeList, (o1, o2) -> o1.weight - o2.weight);
        
        int sum = 0, count = 0;
        for (Edge edge : edgeList) {
            if (unionSet(edge.from, edge.to)) {
                sum += edge.weight;
                if (++count == n - 1) break;
            }
        }
        return sum;
    }
    
    public void initSet(int n) {
        parents = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }
    }
    
    public int findRoot(int a) {
        if (parents[a] == a) return a;
        return parents[a] = findRoot(parents[a]);
    }
    
    public boolean unionSet(int a, int b) {
        int aRoot =  findRoot(a);
        int bRoot = findRoot(b);
        if (aRoot == bRoot) return false;
        parents[bRoot] = aRoot;
        return true;
    }
}