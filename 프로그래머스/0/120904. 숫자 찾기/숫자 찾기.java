import java.util.*;

class Solution {
    public int solution(int num, int k) {
        List<Integer> list = new ArrayList<>();
        while (num > 0) {
            list.add(num % 10);
            num /= 10;
        }
        
        int n = 1;
        for (int i = list.size() - 1; i >= 0; i--) {
            if (list.get(i) == k) return n;
            n++;
        }
        return -1;
    }
}