import java.io.*;
import java.util.*;

class Solution {
    static class File {
        int idx;
        String head;
        String number;
        String tail;
        
        public File(int idx, String head, String number, String tail) {
            this.idx = idx;
            this.head = head;
            this.number = number;
            this.tail = tail;
        }
        
        public String toString() {
            return this.head + this.number + this.tail;
        }
    }
    
    static PriorityQueue<File> pq = new PriorityQueue<>((o1, o2) -> {
        if (o1.head.toLowerCase().equals(o2.head.toLowerCase())) {
            if (Integer.parseInt(o1.number) == Integer.parseInt(o2.number)) return o1.idx - o2.idx;
            return Integer.parseInt(o1.number) - Integer.parseInt(o2.number);
        }
        return o1.head.toLowerCase().compareTo(o2.head.toLowerCase());
    });
    
    public String[] solution(String[] files) {
        int idx = 0;
        for (String file : files) {
            pq.offer(convert(idx++, file));
        }
        
        String[] answer = new String[files.length];
        for (int i = 0; i < files.length; i++) {
            answer[i] = pq.poll().toString();
        }
        return answer;
    }
    
    public File convert(int idx, String file) {
        int start = 0, end = 0;
        for (int i = 0; i < file.length(); i++) {
            char c1 = file.charAt(i);
            if (Character.isDigit(c1)) {
                start = i;
                for (int j = i + 1; j < file.length(); j++) {
                    if (j - i >= 5) {
                        end = j;
                        break;
                    }
                    char c2 = file.charAt(j);
                    if (!Character.isDigit(c2)) {
                        end = j;
                        break;
                    }
                }
                break;
            }
        }
        
        String head = file.substring(0, start);
        String number = end == 0 ? file.substring(start) : file.substring(start, end);
        String tail = end == 0 ? "" : file.substring(end);
        return new File(idx, head, number, tail);
    }
}