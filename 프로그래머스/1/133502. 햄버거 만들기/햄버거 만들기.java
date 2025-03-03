import java.io.*;
import java.util.*;

class Solution {
    static int[] burger = new int[] {1, 2, 3, 1};
    static List<Integer> list = new ArrayList<>();
    
    public int solution(int[] ingredient) {
        for (int i : ingredient) {
            list.add(i);
        }
        
        int answer = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == 1) {
                if (check(i)) {
                    remove(i);
                    i = Integer.max(i - 4, -1);
                    answer++;
                }
            }
        }
        return answer;
    }
    
    public boolean check(int n) {
        for (int i = 0; i < 4; i++) {
            if (n + i >= list.size())
                return false;
            if (list.get(n + i) != burger[i])
                return false;
        }
        return true;
    }
    
    public void remove(int n) {
        for (int i = 0; i < 4; i++) {
            list.remove(n);
        }
    }
}