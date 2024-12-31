import java.io.*;
import java.util.*;

class Solution {
    static Queue<int[]> q = new ArrayDeque<>();
    
    public int solution(int[] numbers, int target) {
        int answer = 0;
        
        q.offer(new int[] {0, 0});
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (cur[0] == numbers.length) {
                if (target == cur[1]) answer++;
                continue;
            }
            q.offer(new int[] {cur[0] + 1, cur[1] + numbers[cur[0]]});
            q.offer(new int[] {cur[0] + 1, cur[1] - numbers[cur[0]]});
        }
        return answer;
    }
}