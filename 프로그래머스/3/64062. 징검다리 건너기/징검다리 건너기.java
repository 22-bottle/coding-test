import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] stones, int k) {
        int left = 0, right = 200_000_000;
        while (left < right) {
            int mid = (left + right) / 2;
            
            int count = 0, max = 0;
            for (int stone : stones) {
                if (stone <= mid) count++;
                else {
                    max = Integer.max(max, count);
                    count = 0;
                }
            }
            max = Integer.max(max, count);
            if (max < k) left = mid + 1;
            else right = mid;
        }
        return left;
    }
}