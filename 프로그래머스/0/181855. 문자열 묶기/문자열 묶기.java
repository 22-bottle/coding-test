class Solution {
    public int solution(String[] strArr) {
        int answer = 0;
        int[] count = new int[30];
        for (String str : strArr) {
            count[str.length() - 1]++;
            answer = Integer.max(answer, count[str.length() - 1]);
        }
        return answer;
    }
}