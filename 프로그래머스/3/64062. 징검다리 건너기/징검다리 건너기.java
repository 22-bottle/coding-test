import java.io.*;
import java.util.*;

class Solution {
    class Node {
        int idx;
        int val;
        
        public Node(int idx, int val) {
            this.idx = idx;
            this.val = val;
        }
    }
    
    static Deque<Node> dq = new ArrayDeque<>();
    
    public int solution(int[] stones, int k) {
        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < stones.length; i++) {
            int stone = stones[i];
            while (!dq.isEmpty() && i - dq.peekFirst().idx >= k)
                dq.pollFirst();
            while (!dq.isEmpty() && dq.peekLast().val < stone)
                dq.pollLast();
            dq.addLast(new Node(i, stone));
            if (i >= k - 1)
                answer = Integer.min(answer, dq.peekFirst().val);
        }
        return answer;
    }
}