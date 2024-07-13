class Solution {
    public int solution(int n) {
        int sum = 0;
        for (int i = n; i > 0; i -= 2) {
            if (n % 2 == 0) sum += i * i;
            else sum += i;
        }
        return sum;
    }
}