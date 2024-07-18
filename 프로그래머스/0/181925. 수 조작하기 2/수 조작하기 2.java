class Solution {
    public String solution(int[] numLog) {
        String answer = "";
        int num = numLog[0];
        for (int i = 1; i < numLog.length; i++) {
            int cur = numLog[i];
            if (num + 1 == cur) {
                answer += "w";
            } else if (num - 1 == cur) {
                answer += "s";
            } else if (num + 10 == cur) {
                answer += "d";
            } else {
                answer += "a";
            }
            num = cur;
        }
        return answer;
    }
}