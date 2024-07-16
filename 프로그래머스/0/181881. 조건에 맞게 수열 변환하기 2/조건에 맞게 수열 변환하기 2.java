class Solution {
    public int solution(int[] arr) {
        int count = 0;
        while (true) {
            boolean changed = false;
            for (int i = 0; i < arr.length; i++) {
                int target = arr[i];
                if (target >= 50 && target % 2 == 0) {
                    arr[i] /= 2;
                    changed = true;
                } else if (target < 50 && target % 2 == 1) {
                    arr[i] = arr[i] * 2 + 1;
                    changed = true;
                }
            }
            if (!changed) return count;
            count++;
        }
    }
}