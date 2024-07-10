import java.io.*;
import java.util.*;

public class Main {
    public static char[] input;
    public static boolean palindrome = true;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input = br.readLine().toCharArray();
        for (int i = 0; i <= input.length / 2; i++) {
            if (input[i] != input[input.length - 1 - i]) {
                palindrome = false;
                break;
            }
        }
        System.out.println(palindrome ? 1 : 0);
    }
}