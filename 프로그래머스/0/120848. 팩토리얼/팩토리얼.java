class Solution {
    public int solution(int n) {
        int num = 3628800;
        int answer = 10;
        while (num > n) {
            num /= answer--;
        }
        return answer;
    }
}