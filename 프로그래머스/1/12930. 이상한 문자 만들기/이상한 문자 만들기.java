class Solution {
    public String solution(String s) {
        char[] sArr = s.toCharArray();
        int idx = 0;
        for (int i = 0; i < sArr.length; i++) {
            if (sArr[i] == ' ') {
                idx = 0;
                continue;
            }
            if (idx % 2 == 0 && sArr[i] >= 97) sArr[i] -= 32;
            else if (idx % 2 == 1 && sArr[i] <= 90) sArr[i] += 32;
            idx++;
        }

        return new String(sArr);
    }
}