import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[][] intervals) {
        List<Integer> list = new ArrayList<>();
        for (int j = 0; j < 2; j++) {
            for (int i = intervals[j][0]; i <= intervals[j][1]; i++) {
                list.add(arr[i]);
            }
        }
        
        int[] answer = new int[list.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}