import java.util.*;

class Solution {
    public String solution(String my_string) {
        Set<Character> set = new HashSet<>();
        String answer = "";
        for (int i = 0; i < my_string.length(); i++) {
            if (set.contains(my_string.charAt(i))) continue;
            answer += my_string.charAt(i);
            set.add(my_string.charAt(i));
        }
        return answer;
    }
}