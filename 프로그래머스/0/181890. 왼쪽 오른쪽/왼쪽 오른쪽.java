import java.util.*;

class Solution {
    public String[] solution(String[] str_list) {
        int s = 0, e = 0;
        for (int i = 0; i < str_list.length; i++) {
            String str = str_list[i];
            if (str.equals("l")) {
                e = i;
                break;
            } else if (str.equals("r")) {
                s = i + 1;
                e = str_list.length;
                break;
            }
        }
        
        String[] answer = s == e ? new String[] {} : new String[e - s];
        for (int i = s; i < e; i++) {
            answer[i - s] = str_list[i];
        }
        return answer;
    }
}