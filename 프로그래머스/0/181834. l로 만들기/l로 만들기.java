class Solution {
    public String solution(String myString) {
        String answer = "";
        char[] myCharArray = myString.toCharArray();
        for (int i = 0; i < myCharArray.length; i++) {
            if (myCharArray[i] < 'l')
                answer += 'l';
            else answer += myCharArray[i];
        }
        return answer;
    }
}