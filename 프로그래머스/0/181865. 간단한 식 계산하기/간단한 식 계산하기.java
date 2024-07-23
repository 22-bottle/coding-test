class Solution {
    public int solution(String binomial) {
        String[] arr = binomial.split(" ");
        if (arr[1].equals("+")) {
            return Integer.valueOf(arr[0]) + Integer.valueOf(arr[2]);
        } else if (arr[1].equals("-")) {
            return Integer.valueOf(arr[0]) - Integer.valueOf(arr[2]);
        } else {
            return Integer.valueOf(arr[0]) * Integer.valueOf(arr[2]);
        }
    }
}