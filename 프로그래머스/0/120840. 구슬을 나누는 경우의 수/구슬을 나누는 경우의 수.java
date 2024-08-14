class Solution {
    public int solution(int balls, int share) {
        long answer = 1;
        for (int i = 1; i <= share; i++) {
            answer *= balls + 1 - i;
            answer /= i;
        }
        return (int)answer;
    }
}