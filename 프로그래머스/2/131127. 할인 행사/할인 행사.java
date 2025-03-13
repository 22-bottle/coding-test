import java.io.*;
import java.util.*;

class Solution {
    static Map<String, Integer> map = new HashMap<>();
    static int answer = 0;
    
    public int solution(String[] want, int[] number, String[] discount) {
        for (int i = 0; i < want.length; i++) {
            map.put(want[i], number[i]);
        }
        
        for (int i = 0; i < 10; i++) {
            String cur = discount[i];
            if (map.containsKey(cur)) {
                map.put(cur, map.get(cur) - 1);
            }
        }
        check();
        
        for (int i = 10; i < discount.length; i++) {
            String past = discount [i - 10];
            if (map.containsKey(past)) {
                map.put(past, map.get(past) + 1);
            }
            String cur = discount[i];
            if (map.containsKey(cur)) {
                map.put(cur, map.get(cur) - 1);
            }
            check();
        }
        return answer;
    }
    
    public void check() {
        int count = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() < 0) return;
            count += entry.getValue();
        }
        if (count == 0) answer++;
    }
}