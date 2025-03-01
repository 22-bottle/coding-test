class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for (int i = 0; i < n; i++) {
            answer[i] = convert(n, arr1[i], arr2[i]);
        }
        return answer;
    }
    
    public String convert(int n, int s1, int s2) {
        int result = s1 | s2;
        StringBuilder sb = new StringBuilder();
        for (int i = n - 1; i >= 0; i--) {
            if ((result & (1 << i)) != 0)
                sb.append("#");
            else sb.append(" ");
        }
        return sb.toString();
    }
}