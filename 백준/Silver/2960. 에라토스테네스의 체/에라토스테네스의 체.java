import java.io.*;
import java.util.*;

public class Main {
    public static int N, K;
    public static boolean[] prime;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        prime = new boolean[N + 1];
        Arrays.fill(prime, true);
        sieve();
    }

    public static void sieve() {
        int cnt = 0;
        for (int i = 2; i <= N; i++) {
            if (!prime[i]) continue;
            int cur = i;
            while (cur <= N) {
                if (!prime[cur]) {
                    cur += i;
                    continue;
                }
                prime[cur] = false;
                if (++cnt == K) {
                    System.out.println(cur);
                    break;
                }
                cur += i;
            }
        }
    }
}