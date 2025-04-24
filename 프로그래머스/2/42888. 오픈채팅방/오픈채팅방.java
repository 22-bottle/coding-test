import java.io.*;
import java.util.*;

class Solution {
    class Status {
        boolean in;
        String nickname;
        
        public Status(boolean in, String nickname) {
            this.in = in;
            this.nickname = nickname;
        }
    }
    
    static String ENTER = "님이 들어왔습니다.";
    static String LEAVE = "님이 나갔습니다.";
    static Map<String, Status> users = new HashMap<>();
    static List<String[]> logs = new ArrayList<>();
    
    public String[] solution(String[] record) {
        for (String r : record) {
            String[] rArr = r.split(" ");
            if (rArr[0].equals("Enter")) {
                if (users.containsKey(rArr[1])) {
                    users.get(rArr[1]).in = true;
                    users.get(rArr[1]).nickname = rArr[2];
                } else {
                    users.put(rArr[1], new Status(true, rArr[2]));
                }
                logs.add(new String[] {rArr[1], ENTER});
            } else if (rArr[0].equals("Leave")) {
                users.get(rArr[1]).in = false;
                logs.add(new String[] {rArr[1], LEAVE});
            } else {
                users.get(rArr[1]).nickname = rArr[2];
            }
        }
        
        String[] answer = new String[logs.size()];
        for (int i = 0; i < answer.length; i++) {
            String[] log = logs.get(i);
            answer[i] = users.get(log[0]).nickname + log[1];
        }
        return answer;
    }
}