import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int n, int s) {
        if (s < n) return new int[] {-1};
        int[] answer = new int[n];
        Arrays.fill(answer, s / n);
        for (int i = 0; i < s % n; i++) {
            answer[n - 1 - i]++;
        }
        return answer;
    }
}