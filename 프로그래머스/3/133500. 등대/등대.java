import java.io.*;
import java.util.*;

class Solution {
    class Lighthouse {
        int idx;
        boolean visited;
        List<Lighthouse> adjs;
        
        public Lighthouse(int idx) {
            this.idx = idx;
            this.visited = false;
            this.adjs = new ArrayList<>();
        }
    }
    
    static Lighthouse[] lighthouses;
    static int[][] mem;
    
    public int solution(int n, int[][] lighthouse) {
        lighthouses = new Lighthouse[n + 1];
        for (int i = 1; i <= n; i++) {
            lighthouses[i] = new Lighthouse(i);
        }
        
        for (int[] lh : lighthouse) {
            Lighthouse lh1 = lighthouses[lh[0]];
            Lighthouse lh2 = lighthouses[lh[1]];
            lh1.adjs.add(lh2);
            lh2.adjs.add(lh1);
        }
        
        mem = new int[n + 1][2];
        findMin(1);
        return Integer.min(mem[1][0], mem[1][1]);
    }
    
    public void findMin(int n) {
        Lighthouse cur = lighthouses[n];
        cur.visited = true;
        int cnt1 = 1, cnt2 = 0;
        for (Lighthouse child : cur.adjs) {
            if (child.visited) continue;
            findMin(child.idx);
            cnt1 += Integer.min(mem[child.idx][0], mem[child.idx][1]);
            cnt2 += mem[child.idx][0];
        }
        mem[cur.idx][0] = cnt1;
        mem[cur.idx][1] = cnt2;
    }
}