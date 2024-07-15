class Solution {
    public int solution(int a, int d, boolean[] included) {
        int answer = 0;
        int[] sequence = new int[included.length];
        sequence[0] = a;
        if (included[0]) answer += sequence[0];
        for (int i = 1; i < included.length; i++) {
            sequence[i] = sequence[i - 1] + d;
            if (included[i]) answer += sequence[i];
        }
        return answer;
    }
}