import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
        
        int answer = 0;
        int p = B.length - 1;
        for (int i = A.length - 1; i >= 0; i--) {
            int a = A[i];
            if (B[p] > a) {
                p--;
                answer++;
            }
        }
        return answer;
    }
}