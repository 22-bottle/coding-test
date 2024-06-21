import java.io.*;
import java.util.*;

class Solution {
    static int MIN = -1;
    static int MAX = 100000001;
    static int front = MIN, rear = MAX;
    
    public int solution(int[][] targets) {
        Arrays.sort(targets, (o1, o2) -> {
            if (o1[0] == o2[0]) return o1[1] - o2[1];
            else return o1[0] - o2[0];
        });
        
        int answer = 1;
        for (int i = 0; i < targets.length; i++) {
            int[] target = targets[i];
            if (target[0] >= rear) {
                answer++;
                front = target[0];
                rear = target[1];
                continue;
            }
            if (target[0] > front) {
                front = target[0];
            }
            if (target[1] < rear) {
                rear = target[1];
            }
        }
        
        return answer;
    }
}