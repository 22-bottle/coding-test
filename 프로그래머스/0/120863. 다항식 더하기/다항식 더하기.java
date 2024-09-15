import java.io.*;
import java.util.*;

class Solution {
    public String solution(String polynomial) {
        int x = 0, n = 0;
        String[] split = polynomial.split(" ");
        for (int i = 0; i < split.length; i += 2) {
            String s = split[i];
            if (s.charAt(s.length() - 1) == 'x') {
                if (s.length() == 1) x++;
                else x += Integer.parseInt(s.substring(0, s.length() - 1));
            } else n += Integer.parseInt(s);
        }
        String answer = "";
        if (x != 0) {
            if (x != 1) answer += x;
            answer += "x";
            if (n != 0) answer += " + ";
        }
        if (n != 0) answer += n;
        return answer;
    }
}