import java.io.*;
import java.util.*;

class Solution {
    static int[] first = new int[10001];
    static int[] second = new int[10001];
    
    public int solution(int[] topping) {
        int answer = 0, fCount = 0, sCount = 0;
        for (int top : topping) {
            if (second[top] == 0) sCount++;
            second[top]++;
        }
        
        for (int top : topping) {
            if (first[top] == 0) fCount++;
            first[top]++;
            second[top]--;
            if (second[top] == 0) sCount--;
            if (fCount == sCount) answer++;
        }
        return answer;
    }
}