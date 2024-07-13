class Solution {
    public int solution(int a, int b) {
        String s1 = Integer.toString(a);
        String s2 = Integer.toString(b);
        int ab = Integer.valueOf(s1 + s2);
        int ba = Integer.valueOf(s2 + s1);
        if (ab > ba) return ab;
        else return ba;
    }
}