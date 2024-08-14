import java.util.*;

class Solution {
    static PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);
    
    public int[] solution(int[] emergency) {
        for (int i = 0; i < emergency.length; i++) {
            pq.offer(new int[] {i, emergency[i]});
        }
        
        int[] answer = new int[emergency.length];
        int rank = 1;
        while (!pq.isEmpty()) {
            answer[pq.poll()[0]] = rank++;
        }
        return answer;
    }
}