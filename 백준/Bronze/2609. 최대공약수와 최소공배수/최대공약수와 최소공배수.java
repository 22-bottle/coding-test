import java.io.*;
import java.util.*;

public class Main {
    public static int N, M;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int gcd = gcd();
        int lcm = lcm(gcd);
        System.out.println(gcd + "\n" + lcm);
    }

    public static int gcd() {
        int a = Integer.max(N, M);
        int b = Integer.min(N, M);
        while (a % b != 0) {
            int c = a % b;
            a = b;
            b = c;
        }
        return b;
    }

    public static int lcm(int gcd) {
        return N * M / gcd;
    }
}