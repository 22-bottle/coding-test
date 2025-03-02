import java.io.*;
import java.util.*;

class Stage {
    int num;
    double rate;
    
    public Stage(int num, double rate) {
        this.num = num;
        this.rate = rate;
    }
}

class Solution {
    static int[] players;
    static PriorityQueue<Stage> pq = new PriorityQueue<>((o1, o2) -> {
        if (o1.rate == o2.rate) return o1.num - o2.num;
        return Double.compare(o2.rate, o1.rate);
    });
    
    public int[] solution(int N, int[] stages) {
        players = new int[N + 2];
        for (int stage : stages) {
            players[stage]++;
        }
        
        int sum = players[N + 1];
        for (int i = N; i > 0; i--) {
            int cur = players[i];
            sum += cur;
            if (sum == 0) pq.offer(new Stage(i, 0));
            else pq.offer(new Stage(i, (double)cur/sum));
        }
        
        int[] answer = new int[N];
        for (int i = 0; i < N; i++) {
            answer[i] = pq.poll().num;
        }
        return answer;
    }
}