import java.io.*;
import java.util.*;

class Solution {
    
    static Map<String, Integer> map = new HashMap<>();
    
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        map.put("code", 0);
        map.put("date", 1);
        map.put("maximum", 2);
        map.put("remain", 3);
        
        int i_ext = map.get(ext);
        int i_sort_by = map.get(sort_by);
        
        Queue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            return o1[i_sort_by] - o2[i_sort_by];
        });
        
        for (int i = 0; i < data.length; i++) {
            if (data[i][i_ext] < val_ext) {
                pq.offer(data[i]);
            }
        }
        
        int count = pq.size();
        int[][] answer = new int[count][4];
        for (int i = 0; i < count; i++) {
            answer[i] = pq.poll();
        }
        return answer;
    }
}