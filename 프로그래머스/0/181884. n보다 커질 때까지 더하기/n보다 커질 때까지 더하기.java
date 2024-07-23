class Solution {
    public int solution(int[] numbers, int n) {
        int answer = 0, idx = 0;
        while (idx < numbers.length && answer <= n) {
            answer += numbers[idx++];
        }
        return answer;
    }
}