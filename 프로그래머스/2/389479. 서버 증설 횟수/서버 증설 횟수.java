import java.io.*;
import java.util.*;

class Solution {
    static int[] endServer;
    
    public int solution(int[] players, int m, int k) {
        endServer = new int[players.length + k];
        int answer = 0, curServer = 1;
        for (int t = 0; t < players.length; t++) {
            int player = players[t];
            curServer -= endServer[t];
            int capacity = m * curServer;
            if (player >= capacity) {
                int newServer = (player - capacity) / m + 1;
                answer += newServer;
                curServer += newServer;
                endServer[t + k] = newServer;
            }
        }
        return answer;
    }
}