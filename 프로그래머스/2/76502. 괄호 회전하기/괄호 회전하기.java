import java.io.*;
import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        for (int i = 0; i < s.length(); i++) {
            if (check(s.substring(i) + s.substring(0, i)))
                answer++;
        }
        return answer;
    }
    
    public boolean check(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (cur == '(' || cur == '[' || cur == '{')
                stack.push(cur);
            else {
                if (stack.isEmpty()) return false;
                if (cur == ')') {
                    if (stack.peek() == '(') stack.pop();
                    else return false;
                } else if (cur == ']') {
                    if (stack.peek() == '[') stack.pop();
                    else return false;
                } else if (cur == '}') {
                    if (stack.peek() == '{') stack.pop();
                    else return false;
                }
            }
        }
        if (!stack.isEmpty()) return false;
        return true;
    }
}