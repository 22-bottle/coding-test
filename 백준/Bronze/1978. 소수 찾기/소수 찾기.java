import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int count = 0;
        for (int i = 0; i < N; i++) {
            count += isPrime(Integer.parseInt(st.nextToken()));
        }
        System.out.println(count);
    }

    public static int isPrime(int n) {
        if (n == 1) return 0;
        boolean isPrime = true;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                isPrime = false;
                break;
            }
        }
        if (isPrime) return 1;
        else return 0;
    }
}