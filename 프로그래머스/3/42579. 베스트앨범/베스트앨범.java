import java.io.*;
import java.util.*;

class Data {
    String genre;
    int sum;
    
    public Data(String genre, int sum) {
        this.genre = genre;
        this.sum = sum;
    }
}

class Solution {
    static Map<String, Integer> imap = new HashMap<>();
    static Map<String, PriorityQueue<int[]>> pmap = new HashMap<>();
    static PriorityQueue<Data> pq = new PriorityQueue<>((o1, o2) -> {
        return o2.sum - o1.sum;
    });
    
    public int[] solution(String[] genres, int[] plays) {
        for (int i = 0; i < plays.length; i++) {
            String genre = genres[i];
            int play = plays[i];
            if (!imap.containsKey(genre)) {
                imap.put(genre, 0);
                pmap.put(genre, new PriorityQueue<>((o1, o2) -> {
                    if (o1[1] == o2[1]) return o1[0] - o2[0];
                    return o2[1] - o1[1];
                }));
            }
            imap.put(genre, imap.get(genre) + play);
            pmap.get(genre).offer(new int[] {i, play});
        }
        
        for (Map.Entry<String, Integer> entry : imap.entrySet()) {
            pq.offer(new Data(entry.getKey(), entry.getValue()));
        }
        
        List<Integer> list = new ArrayList<>();
        while (!pq.isEmpty()) {
            Data cur = pq.poll();
            PriorityQueue<int[]> curPQ = pmap.get(cur.genre);
            for (int i = 0; i < 2; i++) {
                if (curPQ.isEmpty()) break;
                list.add(curPQ.poll()[0]);
            }
        }
        
        int[] answer = new int[list.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}