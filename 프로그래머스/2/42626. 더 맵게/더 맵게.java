import java.io.*;
import java.util.*;

class Solution {
    static PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
        return o1 - o2;
    });
    
    public int solution(int[] scoville, int K) {
        for (int i : scoville) {
            pq.offer(i);
        }
        
        int answer = 0;
        while (!pq.isEmpty()) {
            int first = pq.poll();
            if (first >= K) break;
            if (pq.isEmpty()) return -1;
            int second = pq.poll();
            pq.offer(first + second * 2);
            answer++;
        }
        return answer;
    }
}