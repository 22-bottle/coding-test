import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String line = br.readLine();
            if (line.equals(".")) break;

            boolean balanced = true;
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < line.length(); i++) {
                char c = line.charAt(i);
                if (c == '(') stack.push(c);
                else if (c == ')') {
                    if (stack.isEmpty() || stack.peek() != '(') {
                        balanced = false;
                        break;
                    }
                    stack.pop();
                } else if (c == '[') stack.push(c);
                else if (c == ']') {
                    if (stack.isEmpty() || stack.peek() != '[') {
                        balanced = false;
                        break;
                    }
                    stack.pop();
                }
            }
            if (!stack.isEmpty()) balanced = false;
            if (balanced) sb.append("yes").append("\n");
            else sb.append("no").append("\n");
        }
        System.out.println(sb);
    }
}