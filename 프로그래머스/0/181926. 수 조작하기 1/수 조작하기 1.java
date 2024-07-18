class Solution {
    public int solution(int n, String control) {
        char[] cArray = control.toCharArray();
        for (char c : cArray) {
            if (c == 'w') {
                n++;
            } else if (c == 's') {
                n--;
            } else if (c == 'd') {
                n += 10;
            } else {
                n -= 10;
            }
        }
        return n;
    }
}