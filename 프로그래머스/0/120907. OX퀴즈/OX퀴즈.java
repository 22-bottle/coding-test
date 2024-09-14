import java.io.*;
import java.util.*;

class Solution {
    static List<String> list = new ArrayList<>();
    
    public String[] solution(String[] quiz) {
        for (String s : quiz) {
            String[] split = s.split(" ");
            int x = Integer.parseInt(split[0]);
            int y = Integer.parseInt(split[2]);
            int z = Integer.parseInt(split[4]);
            if (split[1].equals("+") && x + y == z) {
                list.add("O");
            } else if (split[1].equals("-") && x - y == z) {
                list.add("O");
            } else list.add("X");
        }
        return list.toArray(new String[list.size()]);
    }
}