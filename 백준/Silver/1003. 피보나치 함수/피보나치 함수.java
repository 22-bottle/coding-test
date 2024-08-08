import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] mem = new int[41][2];
        mem[0] = new int[] {1, 0}; mem[1] = new int[] {0, 1};
        for (int i = 2; i <= 40; i++) {
            mem[i][0] = mem[i - 1][1];
            mem[i][1] = mem[i - 1][1] + mem[i - 2][1];
        }

        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            sb.append(mem[n][0]).append(" ").append(mem[n][1]).append("\n");
        }
        System.out.println(sb);
    }
}