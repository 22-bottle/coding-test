import java.io.*;
import java.util.*;

public class Main {
    static List<Integer> list = new ArrayList<>();
    static int[] mem;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        mem = new int[N + 1];

        int i = 1;
        while (i * i <= N) {
            list.add(i * i);
            i++;
        }

        for (int k = 1; k <= N; k++) {
            int min = Integer.MAX_VALUE;
            for (int j : list) {
                if (j > k) break;
                min = Math.min(min, mem[k - j]);
            }
            mem[k] = min + 1;
        }
        System.out.println(mem[N]);
    }
}