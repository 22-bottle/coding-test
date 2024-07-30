import java.util.*;

class Solution {
    public int[] solution(int[] arr, int k) {
        int[] answer = new int[k];
        Arrays.fill(answer, -1);
        boolean[] selected = new boolean[100000];
        
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (!selected[arr[i]]) {
                answer[count++] = arr[i];
                selected[arr[i]] = true;
                if (count == k) break;
            }
        }
        return answer;
    }
}