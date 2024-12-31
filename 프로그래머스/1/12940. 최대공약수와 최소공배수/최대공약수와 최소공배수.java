import java.io.*;
import java.util.*;

class Solution {
    static int bigger, smaller;
    public int[] solution(int n, int m) {
        bigger = Integer.max(n, m);
        smaller = Integer.min(n, m);
        
        while (smaller != 0) {
            int temp = bigger % smaller;
            bigger = smaller;
            smaller = temp;
        }
        return new int[] {bigger, n * m / bigger};
    }
}