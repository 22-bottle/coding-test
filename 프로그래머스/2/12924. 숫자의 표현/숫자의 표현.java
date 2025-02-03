import java.io.*;
import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 1;
        int s = n - 1;
        int e = n;
        
        while (s > 0) {
            int sum = (s + e) * (e - s + 1) / 2;
            if (sum < n) s--;
            else if (sum > n) s = --e - 1;
            else {
                answer++;
                s = --e - 1;
            }
        }
        
        return answer;
    }
}