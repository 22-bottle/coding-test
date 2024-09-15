class Solution {
    public int solution(int n) {
        int num = 0;
        for (int i = 1; i <= n; i++) {
            num++;
            while (num % 3 == 0 || check(num)) {
                num++;
            }
        }
        return num;
    }
    
    public boolean check(int n) {
        while (n > 0) {
            if (n % 10 == 3)
                return true;
            n /= 10;
        }
        return false;
    }
}