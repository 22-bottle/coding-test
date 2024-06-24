import java.io.*;
import java.util.*;

class Solution {
    static PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
    
    public int solution(int k, int[] tangerine) {
        Arrays.sort(tangerine);
        
        int count = 0, curSize = 0;
        for (int i = 0; i < tangerine.length; i++) {
            if (curSize != tangerine[i]) {
                curSize = tangerine[i];
                pq.offer(count);
                count = 1;
            } else count++;
        }
        pq.offer(count);
        
        int sizeCount = 0;
        while (k > 0) {
            k -= pq.poll();
            sizeCount++;
        }
        return sizeCount;
    }
}