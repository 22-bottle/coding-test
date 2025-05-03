import java.io.*;
import java.util.*;

class Solution {
    static boolean state = false;
    static Map<String, Integer> gemIdx = new HashMap<>();
    static int[] count, answer = {0, 100_001};
    static int start = 0, end = 0;
    
    public int[] solution(String[] gems) {
        int idx = 0;
        for (String gem : gems) {
            if (!gemIdx.containsKey(gem))
                gemIdx.put(gem, idx++);
        }
        count = new int[idx];
        
        count[gemIdx.get(gems[0])]++;
        check();
        while (end < gems.length - 1 || state) {
            if (!state) {
                String gem = gems[++end];
                count[gemIdx.get(gem)]++;
            } else {
                String gem = gems[start++];
                count[gemIdx.get(gem)]--;
            }
            check();
        }
        return answer;
    }
    
    public void check() {
        for (int i = 0; i < count.length; i++) {
            if (count[i] == 0) {
                state = false;
                return;
            }
        }
        state = true;
        if (answer[1] - answer[0] > end - start) {
            answer[0] = start + 1;
            answer[1] = end + 1;
        }
    }
}