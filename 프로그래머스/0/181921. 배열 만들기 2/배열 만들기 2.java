import java.util.*;

class Solution {
    static int R;
    static List<Integer> list = new ArrayList<>();
    
    public int[] solution(int l, int r) {
        R = count(r);
        int n = 1;
        while (true) {
            int now = create(n++);
            if (now > r) break;
            if (now >= l) {
                list.add(now);
            }
        }
        
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer.length == 0 ? new int[] {-1} : answer;
    }
    
    public int create(int n) {
        int sum = 0;
        for (int i = 0; i <= R; i++) {
            if ((n & (1 << i)) != 0) {
                sum += 5 * Math.pow(10, i);
            }
        }
        return sum;
    }
    
    public int count(int n) {
        int count = 0;
        while (n > 0) {
            n /= 10;
            count++;
        }
        return count;
    }
}