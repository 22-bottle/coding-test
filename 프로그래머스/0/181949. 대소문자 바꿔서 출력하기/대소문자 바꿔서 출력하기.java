import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        char[] a = sc.next().toCharArray();
        for (char c : a) {
            if (c <= 90) {
                c += 32;
            } else {
                c -= 32;
            }
            sb.append(c);
        }
        System.out.println(sb);
    }
}