import java.io.*;
import java.util.*;

class Solution {
    static int s, e;
    
    public int solution(int[][] routes) {
        Arrays.sort(routes, (o1, o2) -> {
            if (o1[0] == o2[0]) return o1[1] - o2[1];
            return o1[0] - o2[0];
        });

        int answer = 1;
        s = routes[0][0];
        e = routes[0][1];
        for (int i = 0; i < routes.length; i++) {
            if (canInclude(routes[i])) {
                reorder(routes[i]);
            } else {
                s = routes[i][0];
                e = routes[i][1];
                answer++;
            }
        }
        return answer;
    }
    
    public void reorder(int[] route) {
        s = Integer.max(s, route[0]);
        e = Integer.min(e, route[1]);
    }
    
    public boolean canInclude(int[] route) {
        if (route[0] > e || route[1] < s) return false;
        return true;
    }
}