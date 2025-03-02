import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        while (true) {
            if (check(wallet, bill)) break;
            if (bill[0] < bill[1]) bill[1] /= 2;
            else bill[0] /= 2;
            answer++;
        }
        return answer;
    }
    
    public boolean check(int[] wallet, int[] bill) {
        if (Integer.min(bill[0], bill[1]) <= Integer.min(wallet[0], wallet[1])) {
            if (Integer.max(bill[0], bill[1]) <= Integer.max(wallet[0], wallet[1]))
                return true;
        }
        return false;
    }
}