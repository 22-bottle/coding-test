import java.io.*;
import java.util.*;

class Solution {
    static int lower = Integer.MAX_VALUE, upper = 0;

    public int solution(int[] diffs, int[] times, long limit) {
        for (int diff : diffs) {
            upper = Integer.max(upper, diff);
            lower = Integer.min(lower, diff);
        }

        while (lower < upper) {
            search(diffs, times, limit);
        }
        return lower;
    }

    public void search(int[] diffs, int[] times, long limit) {
        int mid = (lower + upper) / 2;
        int[] count = new int[diffs.length];
        for (int i = 0; i < diffs.length; i++) {
            if (diffs[i] <= mid) count[i]++;
            else {
                count[i - 1] += diffs[i] - mid;
                count[i] += diffs[i] - mid + 1;
            }
        }

        long sum = 0;
        for (int i = 0; i < diffs.length; i++) {
            sum += times[i] * count[i];
        }
        if (sum > limit) lower = mid + 1;
        else upper = mid;
    }
}