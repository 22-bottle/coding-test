import java.io.*;
import java.util.*;

class Data {
    String city;
    int idx;
    
    public Data(String city, int idx) {
        this.city = city;
        this.idx = idx;
    }
}

class Solution {
    static Set<String> set = new HashSet<>();
    static Map<String, Integer> map = new HashMap<>();
    static PriorityQueue<Data> pq = new PriorityQueue<>((o1, o2) -> {
        return o1.idx - o2.idx;
    });
    
    public int solution(int cacheSize, String[] cities) {
        if (cacheSize == 0) return cities.length * 5;
        int answer = 0;
        for (int i = 0; i < cities.length; i++) {
            String city = cities[i].toLowerCase();
            if (set.contains(city)) { //cache hit
                answer++;
            } else if (set.size() < cacheSize) {
                set.add(city);
                answer += 5;
            } else { //cache miss
                Data target = pq.poll();
                while (target.idx != map.get(target.city)) {
                    target = pq.poll();
                }
                set.remove(target.city);
                set.add(city);
                answer += 5;
            }
            map.put(city, i);
            pq.offer(new Data(city, i));
        }        
        return answer;
    }
}