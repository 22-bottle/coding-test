import java.io.*;
import java.util.*;

class Solution {
    static int idx = 0;
    static long[] answer;
    static Map<Long, Long> map = new HashMap<>();
    
    public long[] solution(long k, long[] room_number) {
        answer = new long[room_number.length];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = arrange(room_number[i]);
        }
        return answer;
    }
    
    public long arrange(long room) {
        if (!map.containsKey(room)) {
            map.put(room, room + 1);
            return room;
        }
        long next = arrange(map.get(room));
        map.put(room, next);
        return next;
    }
}