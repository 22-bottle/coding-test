import java.io.*;
import java.util.*;

class Solution {
    static Queue<Integer> q = new ArrayDeque<>();
    static int sum = 0;
    
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        for (int i = 0; i < bridge_length; i++) {
            q.offer(0);
        }
        
        int answer = 0;
        for (int i = 0; i < truck_weights.length; i++) {
            int curTruck = truck_weights[i];
            while (sum - q.peek() + curTruck > weight) {
                sum -= q.poll();
                q.offer(0);
                answer++;
            }
            sum -= q.poll();
            q.offer(curTruck);
            sum += curTruck;
            answer++;
        }
        return answer + bridge_length;
    }
}