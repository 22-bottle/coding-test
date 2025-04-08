import java.io.*;
import java.util.*;

class Solution {
    static Stack<Integer> stack = new Stack<>();
    
    public int solution(int[] order) {
        int box = 1;
        int idx = 0;
        while (idx < order.length) {
            int target = order[idx];
            if (box > target && stack.peek() > target) break;
            while (target > box) {
                stack.push(box++);
            }
            if (target == box) {
                idx++;
                box++;
                continue;
            }
            if (stack.peek() == target) {
                stack.pop();
                idx++;
            }
        }
        return idx;
    }
}