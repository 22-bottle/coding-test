class Solution {
    public int solution(int n) {
        int i = 1;
        while (i * i < n) {
            i++;
        }
        return i * i == n ? 1 : 2;
    }
}