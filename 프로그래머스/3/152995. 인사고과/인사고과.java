import java.io.*;
import java.util.*;

class Solution {
    class Emp {
        int idx;
        int s1;
        int s2;
        int sum;
        
        public Emp(int idx, int s1, int s2, int sum) {
            this.idx = idx;
            this.s1 = s1;
            this.s2 = s2;
            this.sum = sum;
        }
    }
    
    static List<Emp> list = new ArrayList<>();
    
    public int solution(int[][] scores) {
        for (int i = 0; i < scores.length; i++) {
            list.add(new Emp(i, scores[i][0], scores[i][1], scores[i][0] + scores[i][1]));
        }
        Collections.sort(list, (o1, o2) -> {
            if (o1.s1 != o2.s1) return o2.s1 - o1.s1;
            return o1.s2 - o2.s2;
        });
        
        for (int i = 0; i < list.size() - 1; i++) {
            Emp cur = list.get(i);
            if (cur.s1 == list.get(i + 1).s1) continue;
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(j).s2 < cur.s2) list.remove(j--);
            }
        }
        
        Collections.sort(list, (o1, o2) -> {
            if (o1.sum != o2.sum) return o2.sum - o1.sum;
            return o1.idx - o2.idx;
        });
        int rank = 1;
        for (Emp e : list) {
            if (e.idx == 0) return rank;
            rank++;
        }
        return -1;
    }
}