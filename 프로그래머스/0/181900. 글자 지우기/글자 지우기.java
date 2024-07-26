class Solution {
    public String solution(String my_string, int[] indices) {
        boolean[] b = new boolean[my_string.length()];
        for (int i = 0; i < indices.length; i++) {
            b[indices[i]] = true;
        }
        
        String answer = "";
        for (int i = 0; i < my_string.length(); i++) {
            if (!b[i])
                answer += my_string.charAt(i);
        }
        return answer;
    }
}