import java.util.*;

class Solution {
    static PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
        return o2[0] - o1[0];
    });
    
    public int solution(int a, int b, int c, int d) {
        check(new int[] {a, b, c, d});
        
        int[] cur = pq.poll();
        if (cur[0] == 4) {
            return 1111 * cur[1];
        } else if (cur[0] == 3) {
            int n = 10 * cur[1] + pq.poll()[1];
            return n * n;
        } else if (cur[0] == 2) {
            int[] next = pq.poll();
            if (next[0] == 2) {
                return (cur[1] + next[1]) * Math.abs(cur[1] - next[1]);
            } else {
                return next[1] * pq.poll()[1];
            }
        } else {
            int result = cur[1];
            while (!pq.isEmpty()) {
                result = Integer.min(result, pq.poll()[1]);
            }
            return result;
        }
    }
    
    public void check(int[] nums) {
        int[] count = new int[7];
        for (int i : nums) {
            count[i]++;
        }
        
        for (int i = 1; i <= 6; i++) {
            if (count[i] != 0)
                pq.offer(new int[] {count[i], i});
        }
    }
}