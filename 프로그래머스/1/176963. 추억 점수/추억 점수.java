import java.io.*;
import java.util.*;

class Solution {
    static Map<String, Integer> map = new HashMap<>();
    
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        for (int i = 0; i < name.length; i++) {
            map.put(name[i], yearning[i]);
        }
        
        int[] answer = new int[photo.length];
        for (int i = 0; i < photo.length; i++) {
            int sum = 0;
            for (String s : photo[i]) {
                sum += map.getOrDefault(s, 0);
            }
            answer[i] = sum;
        }
        return answer;
    }
}