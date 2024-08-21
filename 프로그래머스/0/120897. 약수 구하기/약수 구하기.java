import java.util.*;

class Solution {
    public int[] solution(int n) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                pq.offer(i);
                if (i * i != n) pq.offer(n / i);
            }
        }
        
        int[] answer = new int[pq.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = pq.poll();
        }
        return answer;
    }
}