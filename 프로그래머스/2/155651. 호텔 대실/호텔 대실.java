import java.io.*;
import java.util.*;

class Solution {
    class Time {
        int time;
        int type;
        
        public Time(int time, int type) {
            this.time = time;
            this.type = type;
        }
    }
    
    static PriorityQueue<Time> pq = new PriorityQueue<>((o1, o2) -> {
        if (o1.time == o2.time) return o1.type - o2.type;
        return o1.time - o2.time;
    });
    
    public int solution(String[][] book_time) {
        for (String[] bt : book_time) {
            pq.offer(new Time(convert(bt[0]), 1));
            pq.offer(new Time(convert(bt[1]) + 10, -1));
        }
        
        int max = 0, now = 0;
        while (!pq.isEmpty()) {
            Time cur = pq.poll();
            now += cur.type;
            max = Integer.max(max, now);
        }
        return max;
    }
    
    public int convert(String time) {
        return Integer.valueOf(time.substring(0, 2)) * 60 + Integer.valueOf(time.substring(3));
    }
}