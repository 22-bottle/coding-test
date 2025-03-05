import java.io.*;
import java.util.*;

class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int[] first = new int[] {0, 0};
        int[] last = str2int(video_len);
        int[] opStart = str2int(op_start);
        int[] opEnd = str2int(op_end);
        
        int[] present = str2int(pos);
        if (compare(opStart, present) && compare(present, opEnd))
                present = opEnd;
        for (String command : commands) {
            if (command.equals("next")) {
                present = add(present, 10);
                if (!compare(present, last)) present = last;
            } else {
                present = add(present, -10);
                if (!compare(first, present)) present = first;
            }
            if (compare(opStart, present) && compare(present, opEnd))
                present = opEnd;
        }
        return int2str(present);
    }
    
    public boolean compare(int[] first, int[] second) {
        if (first[0] < second[0]) return true;
        if (first[0] > second[0]) return false;
        if (first[1] < second[1]) return true;
        if (first[1] > second[1]) return false;
        return true;
    }
    
    public int[] add(int[] time, int n) {
        int min = time[0];
        int sec = time[1] + n;
        if (sec >= 60) {
            sec -= 60;
            min++;
        } else if (sec < 0) {
            sec += 60;
            min--;
        }
        return new int[] {min, sec};
    }
    
    public int[] str2int(String str) {
        int[] time = new int[2];
        String[] split = str.split(":");
        time[0] = Integer.valueOf(split[0]);
        time[1] = Integer.valueOf(split[1]);
        return time;
    }
    
    public String int2str(int[] time) {
        String str = ":";
        if (time[0] < 10) str = "0" + time[0] + str;
        else str = time[0] + str;
        if (time[1] < 10) str += "0" + time[1];
        else str += time[1];
        return str;
    }
}