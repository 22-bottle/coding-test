class Solution {
    public int[] solution(int[] array) {
        int mv = -1, mi = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > mv) {
                mv = array[i];
                mi = i;
            }
        }
        return new int[] {mv, mi};
    }
}