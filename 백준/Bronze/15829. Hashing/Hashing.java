import java.io.*;
import java.util.*;

public class Main {
    static final long R = 31;
    static final long M = 1234567891;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String s = br.readLine();
        long result = 0, p = 1;
        for (int i = 0; i < N; i++) {
            long c = s.charAt(i) - 'a' + 1;
            result += c * p;
            p = (p * R) % M;
        }
        System.out.println(result % M);
    }
}