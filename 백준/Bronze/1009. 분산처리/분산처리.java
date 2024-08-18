import java.io.*;
import java.util.*;

public class Main {
    static int T, A, B;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T  = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            int r = 1;
            for (int i = 0; i < B; i++) {
                r = r * A % 10;
            }
            if (r == 0) r = 10;
            System.out.println(r);
        }
    }
}