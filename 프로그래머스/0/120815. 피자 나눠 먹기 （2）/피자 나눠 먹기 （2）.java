class Solution {
    public int solution(int n) {
        return (n * 6 / gcd(n, 6)) / 6;
    }
    
    public int gcd(int a, int b) {
        int big = Integer.max(a, b);
        int small = Integer.min(a, b);
        while (big % small != 0) {
            int c = big % small;
            big = small;
            small = c;
        }
        return small;
    }
}