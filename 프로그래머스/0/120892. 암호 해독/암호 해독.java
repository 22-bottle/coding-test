class Solution {
    public String solution(String cipher, int code) {
        int num = code - 1;
        String answer = String.valueOf(cipher.charAt(num));
        num += code;
        
        while (num < cipher.length()) {
            answer += cipher.charAt(num);
            num += code;
        }
        return answer;
    }
}