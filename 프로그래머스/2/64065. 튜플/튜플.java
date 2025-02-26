import java.io.*;
import java.util.*;

class Solution {
    static PriorityQueue<String> pq = new PriorityQueue<>((o1, o2) -> {
        return o1.length() - o2.length();
    });
    
    public int[] solution(String s) {
        s = s.substring(2, s.length() - 2);
        String[] arr = s.split("},\\{");
        for (String arrs : arr) {
            pq.offer(arrs);
        }
        
        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        while (!pq.isEmpty()) {
            arr = pq.poll().split(",");
            for (String arrs : arr) {
                int n = Integer.valueOf(arrs);
                if (!set.contains(n)) {
                    list.add(n);
                    set.add(n);
                }
            }
        }
        
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}