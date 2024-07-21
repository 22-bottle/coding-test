import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] sizes = new int[6];
        for (int i = 0; i < 6; i++) {
            sizes[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        int t = 0;
        for (int i = 0; i < 6; i++) {
            if (sizes[i] % T == 0) t += sizes[i] / T;
            else t += sizes[i] / T + 1;
        }
        int p1 = N / P;
        int p2 = N % P;
        System.out.println(t);
        System.out.println(p1 + " " + p2);
    }
}