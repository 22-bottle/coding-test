import java.util.*;

class Solution {
    public int[] solution(int n, int[] slicer, int[] num_list) {
        if (n == 1) {
            return Arrays.copyOfRange(num_list, 0, slicer[1] + 1);
        } else if (n == 2) {
            return Arrays.copyOfRange(num_list, slicer[0], num_list.length);
        } else if (n == 3) {
            return Arrays.copyOfRange(num_list, slicer[0], slicer[1] + 1);
        } else {
            int idx = slicer[0];
            List<Integer> list = new ArrayList<>();
            while (idx <= slicer[1]) {
                list.add(num_list[idx]);
                idx += slicer[2];
            }
            int[] answer = new int[list.size()];
            for (int i = 0; i < answer.length; i++) {
                answer[i] = list.get(i);
            }
            return answer;
        }
    }
}