import java.io.*;
import java.util.*;

public class Main {
    static int T, M, N, X, Y;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            X = Integer.parseInt(st.nextToken()) - 1;
            Y = Integer.parseInt(st.nextToken()) - 1;

            int n = X;
            while (n <= M * N) {
                if (n % N == Y) break;
                n += M;
            }

            if (n > M * N) System.out.println(-1);
            else System.out.println(n + 1);
        }
    }
}