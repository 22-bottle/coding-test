import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] num_list) {
        int sum1 = 0, sum2 = 0;
        for (int i = 0; i < num_list.length; i++) {
            if (i % 2 == 0) sum1 += num_list[i];
            else sum2 += num_list[i];
        }
        return Integer.max(sum1, sum2);
    }
}