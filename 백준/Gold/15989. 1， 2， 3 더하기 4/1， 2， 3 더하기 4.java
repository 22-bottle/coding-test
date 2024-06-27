import java.io.*;
import java.util.*;

public class Main {
    static int T;
    static int[] mem = new int[10001];

    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        mem[0] = 1; mem[1] = 1; mem[2] = 2; mem[3] = 3; mem[4] = 4;
        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            if (mem[n] != 0) {
                sb.append(mem[n]).append("\n");
                continue;
            }
            for (int i = 5; i <= n; i++) {
                if (mem[i] != 0) continue;
                mem[i] = mem[i - 3] + mem[i - 2] + 1 - mem[i - 5];
            }
            sb.append(mem[n]).append("\n");
        }
        System.out.println(sb.toString());
    }
}