import java.io.*;
import java.util.*;

class Solution {
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        for (int i = 0; i < score.length; i++) {
            pq.offer(score[i]);
            if (pq.size() > k) pq.poll();
            answer[i] = pq.peek();
        }
        return answer;
    }
}