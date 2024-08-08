import java.util.*;

class Solution {
    public int solution(int[] array) {
        int[] count = new int[1001];
        int max = 0;
        for (int i = 0; i < array.length; i++) {
            max = Integer.max(max, ++count[array[i]]);
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <= 1000; i++) {
            if (count[i] == max)
                list.add(i);
        }
        return list.size() != 1 ? -1 : list.get(0);
    }
}