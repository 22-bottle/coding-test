import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = schedules.length;
        for (int i = 0; i < schedules.length; i++) {
            int limit = limit(schedules[i]);
            for (int j = 0; j < timelogs[i].length; j++) {
                if (startday + j == 6 || startday + j == 7 || startday + j == 13) continue;
                if (timelogs[i][j] > limit) {
                    answer--;
                    break;
                }
            }
        }
        return answer;
    }
    
    public int limit(int schedule) {
        int hour = schedule / 100;
        int minute = schedule % 100 + 10;
        if (minute >= 60) {
            hour++;
            minute -= 60;
        }
        return hour * 100 + minute;
    }
}