import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] arr) {
        int lcm = arr[0];
        for (int i = 1; i < arr.length; i++) {
            lcm = lcm(lcm, arr[i]);
        }
        return lcm;
    }
    
    public int lcm(int a, int b) {
        int big = Integer.max(a, b);
        int small = Integer.min(a, b);
        while (big % small != 0) {
            int temp = big % small;
            big = small;
            small = temp;
        }
        return a * b / small;
    }
}