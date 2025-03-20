import java.io.*;
import java.util.*;

class Solution {
    static PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
        return o2 - o1;
    });
    
    public long solution(int n, int[] works) {
        for (int work : works) {
            pq.offer(work);
        }
        
        for (int i = 0; i < n; i++) {
            if (pq.isEmpty()) break;
            int cur = pq.poll();
            if (cur - 1 > 0) pq.offer(cur - 1);
        }
        
        long answer = 0;
        while (!pq.isEmpty()) {
            int cur = pq.poll();
            answer += cur * cur;
        }
        return answer;
    }
}