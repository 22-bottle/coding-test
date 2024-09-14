import java.io.*;
import java.util.*;

class Solution {
    static Map<String, int[]> map = new HashMap<>() {{
        put("up", new int[] {0, 1});
        put("down", new int[] {0, -1});
        put("left", new int[] {-1, 0});
        put("right", new int[] {1, 0});
    }};
    
    public int[] solution(String[] keyinput, int[] board) {
        int r = 0, c = 0, nr = board[0] / 2, nc = board[1] / 2;
        for (String s : keyinput) {
            int[] cur = map.get(s);
            r = (r + cur[0] > nr || r + cur[0] < -nr) ? r : r + cur[0];
            c = (c + cur[1] > nc || c + cur[1] < -nc) ? c : c + cur[1];
        }
        return new int[] {r, c};
    }
}