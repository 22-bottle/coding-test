class Solution {
    public int solution(String A, String B) {
        for (int i = 0; i < B.length(); i++) {
            if (A.charAt(0) == B.charAt(i))
                if (check(A, B, i)) return i;
        }
        return -1;
    }
    
    public boolean check(String A, String B, int n) {
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) != B.charAt((n + i) % B.length()))
                return false;
        }
        return true;
    }
}