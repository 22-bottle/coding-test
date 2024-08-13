class Solution {
    public String solution(String my_string, String letter) {
        String[] splitted = my_string.split(letter);
        
        String answer = "";
        for (String s : splitted)
            answer += s;
        return answer;
    }
}