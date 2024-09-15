import java.util.*;

class Solution {
    static PriorityQueue<Integer> pq;
    
    public int[] solution(int[] numlist, int n) {
        pq = new PriorityQueue<>((o1, o2) -> {
            int n1 = Math.abs(o1 - n);
            int n2 = Math.abs(o2 - n);
            if (n1 != n2) return n1 - n2;
            return o2 - o1;
        });
        
        for (int i : numlist) {
            pq.offer(i);
        }
        
        int[] answer = new int[pq.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = pq.poll();
        }
        return answer;
    }
}