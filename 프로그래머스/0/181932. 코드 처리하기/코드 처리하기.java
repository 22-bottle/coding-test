class Solution {
    public String solution(String code) {
        String answer = "";
        int mode = 0;
        for (int i = 0; i < code.length(); i++) {
            char cur = code.charAt(i);
            if (code.charAt(i) == '1') {
                mode = (mode + 1) % 2;
                continue;
            }
            if ((mode == 0 && i % 2 == 0) || (mode == 1 && i % 2 == 1)) {
                answer += code.charAt(i);
            }
        }
        return answer.length() == 0 ? "EMPTY" : answer;
    }
}