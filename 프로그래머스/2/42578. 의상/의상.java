import java.io.*;
import java.util.*;

class Solution {
    static Map<String, Integer> map = new HashMap<>();
    
    public int solution(String[][] clothes) {
        for (String[] cloth : clothes) {
            map.put(cloth[1], map.getOrDefault(cloth[1], 0) + 1);
        }
        
        int answer = 1;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            answer *= entry.getValue() + 1;
        }
        return answer - 1;
    } 
}