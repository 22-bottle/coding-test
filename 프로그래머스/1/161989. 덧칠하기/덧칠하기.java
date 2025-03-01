import java.io.*;
import java.util.*;

class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int done = 0;
        for (int target : section) {
            if (target <= done) continue;
            done = target + m - 1;
            answer++;
        }
        return answer;
    }
}