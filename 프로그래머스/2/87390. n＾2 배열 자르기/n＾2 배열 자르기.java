import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int)(right - left) + 1];
        for (long i = left; i <= right; i++) {
            int r = (int)(i / n) + 1;
            int c = (int)(i % n) + 1;
            answer[(int)(i - left)] = Integer.max(r, c);
        }
        return answer;
    }
}