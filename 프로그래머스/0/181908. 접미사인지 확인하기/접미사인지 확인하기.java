class Solution {
    public int solution(String my_string, String is_suffix) {
        if (is_suffix.length() > my_string.length()) return 0;
        for (int i = 1; i <= is_suffix.length(); i++) {
            if (is_suffix.charAt(is_suffix.length() - i) != my_string.charAt(my_string.length() - i)) return 0;
        }
        return 1;
    }
}