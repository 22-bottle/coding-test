import java.io.*;
import java.util.*;

class Solution {
    static PriorityQueue<Integer> minPQ = new PriorityQueue<>();
    static PriorityQueue<Integer> maxPQ = new PriorityQueue<>((o1, o2) -> {
        return o2 - o1;
    });
    static Map<Integer, Integer> map = new HashMap<>();
    
    public int[] solution(String[] operations) {
        for (String op : operations) {
            String[] sp = op.split(" ");
            int v = Integer.valueOf(sp[1]);
            if (sp[0].equals("I")) {
                maxPQ.offer(v);
                minPQ.offer(v);
                map.put(v, map.getOrDefault(v, 0) + 1);
            } else {
                int target = 0;
                if (v == 1) {
                    arrange(maxPQ);
                    if (maxPQ.isEmpty()) continue;
                    target = maxPQ.poll();
                } else {
                    arrange(minPQ);
                    if (minPQ.isEmpty()) continue;
                    target = minPQ.poll();
                }
                if (map.get(target) == 1) map.remove(target);
                else map.put(target, map.get(target) - 1);
            }
        }
        
        arrange(maxPQ);
        arrange(minPQ);
        int[] answer = maxPQ.isEmpty() ? new int[] {0, 0} : new int[] {maxPQ.poll(), minPQ.poll()};
        return answer;
    }
    
    public void arrange(PriorityQueue<Integer> pq) {
        while (!pq.isEmpty() && map.get(pq.peek()) == null) {
            pq.poll();
        }
    }
}