import java.io.*;
import java.util.*;

class Solution {
    static int MAX = 1000001;
    static int[] srcCnt = new int[MAX];
    static int[] destCnt = new int[MAX];
    
    public int[] solution(int[][] edges) {
        int[] answer = new int[4];
        
        int max = 0;
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            srcCnt[from]++;
            destCnt[to]++;
            max = Integer.max(max, Integer.max(from, to));
        }
        
        for (int i = 1; i < max; i++) {
            if (destCnt[i] == 0 && srcCnt[i] >= 2) {
                answer[0] = i;
                break;
            }
        }

        List<Integer>[] dests = new ArrayList[max + 1];
        for (int i = 1; i <= max; i++) {
            dests[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            dests[from].add(to);
        }
        
        int donut = 0, stick = 0, eight = 0;
        for (Integer start : dests[answer[0]]) {
            int next = start;
            while (true) {
                if (dests[next].size() == 0) {
                    stick++;
                    break;
                } else if (dests[next].size() == 1) {
                    next = dests[next].get(0);
                    if (next == start) {
                        donut++;
                        break;
                    }
                } else {
                    eight++;
                    break;
                }
            }
        }
        answer[1] = donut;
        answer[2] = stick;
        answer[3] = eight;
        return answer;
    }
}