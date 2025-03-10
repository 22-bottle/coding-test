import java.io.*;
import java.util.*;

class Solution {
    static Set<Integer> set = new HashSet<>();
    
    public int solution(int[] elements) {
        for (int start = 0; start < elements.length; start++) {
            int sum = 0;
            for (int move = 0; move < elements.length; move++) {
                sum += elements[(start + move) % elements.length];
                set.add(sum);
            }
        }
        return set.size();
    }
}