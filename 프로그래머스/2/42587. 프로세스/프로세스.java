import java.io.*;
import java.util.*;

class Solution {
    static int[] count = new int[10];
    static Queue<int[]> q = new ArrayDeque<>();
    static int[] seq;
    
    public int solution(int[] priorities, int location) {
        seq = new int[priorities.length];
        
        for (int i = 0; i < priorities.length; i++) {
            q.offer(new int[] {i, priorities[i]});
            count[priorities[i]]++;
        }
        
        int rank = 1;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (check(cur)) {
                seq[cur[0]] = rank++;
                count[cur[1]]--;
                continue;
            }
            q.offer(cur);
        }
        return seq[location];
    }
    
    public boolean check(int[] cur) {
        for (int i = 9; i > cur[1]; i--) {
            if (count[i] > 0) return false;
        }
        return true;
    }
}