class Solution {
    static int[] answer;
    
    public int[] solution(String myString) {
        String[] arr = myString.split("x");
        if (myString.charAt(myString.length() - 1) == 'x')
            answer = new int[arr.length + 1];
        else answer = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            answer[i] = arr[i].length();
        }
        return answer;
    }
}