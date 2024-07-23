class Solution {
    public int solution(String myString, String pat) {
        String newString = "";
        char[] myCharArray = myString.toCharArray();
        for (int i = 0; i < myCharArray.length; i++) {
            if (myCharArray[i] == 'A') newString += "B";
            else newString += "A";
        }
        
        if (newString.contains(pat)) return 1;
        else return 0;
    }
}