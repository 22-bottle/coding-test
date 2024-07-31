class Solution {
    public String solution(String myString, String pat) {
        String answer = "";
        for (int i = myString.length() - pat.length(); i >= 0; i--) {
            if (check(myString, pat, i)) {
                answer = myString.substring(0, i);
                break;
            }
        }
        return answer + pat;
    }
    
    public boolean check(String myString, String pat, int n) {
        for (int i = 0; i < pat.length(); i++) {
            if (pat.charAt(i) != myString.charAt(n + i))
                return false;
        }
        return true;
    }
}