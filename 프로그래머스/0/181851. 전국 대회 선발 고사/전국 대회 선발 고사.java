import java.util.*;

class Solution {
    public int solution(int[] rank, boolean[] attendance) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            return o1[1] - o2[1];
        });
        for (int i = 0; i < rank.length; i++) {
            if (attendance[i])
                pq.offer(new int[] {i, rank[i]});
        }
        return pq.poll()[0] * 10000 + pq.poll()[0] * 100 + pq.poll()[0];
    }
}