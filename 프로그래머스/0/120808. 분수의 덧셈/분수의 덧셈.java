class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int numer = numer1*denom2 + numer2*denom1;
        int denom = denom1 * denom2;
        int gcd = gcd(numer, denom);
        return new int[] {numer/gcd, denom/gcd};
    }
    
    public static int gcd(int n, int m) {
        int a = Integer.max(n, m);
        int b = Integer.min(n, m);
        while (a % b != 0) {
            int c = a % b;
            a = b;
            b = c;
        }
        return b;
    }
}