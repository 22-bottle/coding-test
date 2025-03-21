import java.io.*;
import java.util.*;

class Solution {
    Stack<Integer> stack = new Stack<>();
    
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        stack.push(0);
        for (int i = 1; i < prices.length; i++) {
            int price = prices[i];
            while (!stack.isEmpty() && prices[stack.peek()] > price) {
                int idx = stack.pop();
                answer[idx] = i - idx;
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int idx = stack.pop();
            answer[idx] = prices.length - idx - 1;
        }
        return answer;
    }
}