import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int answer = 0;
            if (N % H == 0) {
                answer += H * 100;
                answer += N / H;
            } else {
                answer += N % H * 100;
                answer += N / H + 1;
            }
            System.out.println(answer);
        }
    }
}