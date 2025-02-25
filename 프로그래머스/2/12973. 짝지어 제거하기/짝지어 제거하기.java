import java.io.*;
import java.util.*;

class Solution {
    static Stack<Character> stack = new Stack<>();
    
    public int solution(String s) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (stack.isEmpty() || stack.peek() != c)
                stack.push(c);
            else stack.pop();
        }
        return stack.isEmpty() ? 1 : 0;
    }
}