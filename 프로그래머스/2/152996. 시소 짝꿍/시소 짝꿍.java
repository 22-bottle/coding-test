import java.io.*;
import java.util.*;

class Solution {
    static Map<Integer, Integer> count = new HashMap<>();
    static Map<Integer, Integer> map = new HashMap<>();
    
    public long solution(int[] weights) {
        for (int weight : weights) {
            for (int i = 2; i <= 4; i++) {
                map.put(weight * i, map.getOrDefault(weight * i, 0) + 1);
            }
            count.put(weight, count.getOrDefault(weight, 0) + 1);
        }
        
        long answer = 0;
        for (int weight : weights) {
            for (int i = 2; i <= 4; i++) {
                answer += map.getOrDefault(weight * i, 1) - 1;
            }
            answer -= (count.getOrDefault(weight, 1) - 1) * 2;
        }
        return answer / 2;
    }
}