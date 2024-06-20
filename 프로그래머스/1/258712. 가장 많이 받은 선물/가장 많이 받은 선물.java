import java.io.*;
import java.util.*;

class Solution {
    
    static int[][] graph;
    static int[][] list;
    
    public int solution(String[] friends, String[] gifts) {
        
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < friends.length; i++) {
            map.put(friends[i], i);
        }
        graph = new int[friends.length][friends.length];
        list = new int[friends.length][3];
        
        for (String gift : gifts) {
            String[] giftInfo = gift.split(" ");
            int from = map.get(giftInfo[0]);
            int to = map.get(giftInfo[1]);
            
            graph[from][to]++;
            list[from][0]++;
            list[to][1]++;
        }
        for (int i = 0; i < friends.length; i++) {
            list[i][2] = list[i][0] - list[i][1];
        }
        
        int answer = 0;
        for (int i = 0; i < friends.length; i++) {
            int count = 0;
            for (int j = 0; j < friends.length; j++) {
                if (i == j) continue;
                if (graph[i][j] == graph[j][i]) {
                    if (list[i][2] > list[j][2]) count++;
                } else {
                    if (graph[i][j] > graph[j][i]) count++;
                }
            }
            answer = Integer.max(answer, count);
            System.out.println(count);
        }
        return answer;
    }
}