import java.io.*;
import java.util.*;

public class Main {
    static final int R = 31;
    static final int M = 1234567891;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String s = br.readLine();
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a' + 1;
            int p = power(i);
            result += c * p % M;
        }
        System.out.println(result);
    }

    public static int power(int n) {
        int result = 1;
        for (int i = 0; i < n; i++) {
            result = result * R % M;
        }
        return result;
    }
}