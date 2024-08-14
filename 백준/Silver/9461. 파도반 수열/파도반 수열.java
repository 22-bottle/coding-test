import java.io.*;
import java.util.*;

public class Main {
    static int T, N;
    static long[] mem;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            mem = new long[N + 1];
            if (N >= 1) mem[1] = 1;
            if (N >= 2) mem[2] = 1;
            if (N >= 3) mem[3] = 1;
            if (N >= 4) mem[4] = 2;
            if (N >= 5) mem[5] = 2;
            for (int i = 6; i <= N; i++) {
                mem[i] = mem[i - 1] + mem[i - 5];
            }
            sb.append(mem[N]).append("\n");
        }
        System.out.println(sb);
    }
}