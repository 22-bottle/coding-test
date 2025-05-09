import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = check(arrayA, arrayB);
        answer = Integer.max(answer, check(arrayB, arrayA));
        return answer;
    }
    
    public int check(int[] a, int[] b) {
        int gcd = a[0];
        for (int i = 1; i < a.length; i++) {
            gcd = gcd(gcd, a[i]);
        }
        if (gcd == 1) return 0;
        for (int i = 0; i < b.length; i++) {
            if (b[i] % gcd == 0) return 0;
        }
        return gcd;
    }
    
    public int gcd(int a, int b) {
        int larger = Integer.max(a, b);
        int smaller = Integer.min(a, b);
        while (larger % smaller != 0) {
            int temp = larger % smaller;
            larger = smaller;
            smaller = temp;
        }
        return smaller;
    }
}