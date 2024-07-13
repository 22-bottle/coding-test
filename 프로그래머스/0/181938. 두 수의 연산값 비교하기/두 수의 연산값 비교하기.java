class Solution {
    public int solution(int a, int b) {
        int ab = Integer.valueOf(Integer.toString(a) + Integer.toString(b));
        return Integer.max(ab, 2 * a * b);
    }
}