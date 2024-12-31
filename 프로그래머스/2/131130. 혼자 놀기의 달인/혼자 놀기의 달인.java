import java.io.*;
import java.util.*;

class Solution {
    static boolean[] checked;
    static PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
        return o2 - o1;
    });
    
    public int solution(int[] cards) {
        checked = new boolean[cards.length];
        
        for (int start = 0; start < cards.length; start++) {
            if (checked[start]) continue;
            
            int count = 0, cur = start;
            while (!checked[cur]) {
                count++;
                checked[cur] = true;
                cur = cards[cur] - 1;
            }
            
            pq.offer(count);
        }
        if (pq.size() == 1) return 0;
        return pq.poll() * pq.poll();
    }
}