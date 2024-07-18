import java.util.*;

class Solution {
    public String[] solution(String my_string) {
        String[] splited = my_string.split(" ");
        List<String> list = new ArrayList<>();
        for (String s : splited) {
            if (s.length() == 0) continue;
            list.add(s);
        }
        return list.toArray(new String[list.size()]);
    }
}