import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = new int[] {51, 51, -1, -1};
        for (int i = 0; i < wallpaper.length; i++) {
            for (int j = 0; j < wallpaper[0].length(); j++) {
                if (wallpaper[i].charAt(j) == '.') continue;
                answer[0] = Integer.min(answer[0], i);
                answer[1] = Integer.min(answer[1], j);
                answer[2] = Integer.max(answer[2], i + 1);
                answer[3] = Integer.max(answer[3], j + 1);
            }
        }
        return answer;
    }
}