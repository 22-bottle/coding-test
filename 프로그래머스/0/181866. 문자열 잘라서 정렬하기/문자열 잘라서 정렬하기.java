import java.util.*;

class Solution {
    public String[] solution(String myString) {
        String[] arr = myString.split("x");
        Arrays.sort(arr);
        int cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length() != 0)
                break;
            cnt++;
        }
        return Arrays.copyOfRange(arr, cnt, arr.length);
    }
}