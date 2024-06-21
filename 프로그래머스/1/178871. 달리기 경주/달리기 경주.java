import java.io.*;
import java.util.*;

class Solution {
    
    static Map<String, Integer> map = new HashMap<>();
    
    public String[] solution(String[] players, String[] callings) {
        for (int i = 0; i < players.length; i++) {
            map.put(players[i], i);
        }
        
        for (int i = 0; i < callings.length; i++) {
            String cur = callings[i];
            int cur_rank = map.get(cur);
            String next = players[cur_rank - 1];
            
            map.put(cur, cur_rank - 1);
            map.put(next, cur_rank);
            String temp = players[cur_rank - 1];
            players[cur_rank - 1] = players[cur_rank];
            players[cur_rank] = temp;
        }
        
        return players;
    }
}