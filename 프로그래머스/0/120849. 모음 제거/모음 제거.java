import java.util.*;

class Solution {
    public String solution(String my_string) {
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < my_string.length(); i++) {
            if (!check(my_string.charAt(i)))
                list.add(my_string.charAt(i));
        }
        
        String answer = "";
        for (char c : list) answer += c;
        return answer;
    }
    
    public boolean check(char c) {
        if (c == 'a') return true;
        if (c == 'e') return true;
        if (c == 'i') return true;
        if (c == 'o') return true;
        if (c == 'u') return true;
        return false;
    }
}