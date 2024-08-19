import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static String S1, S2;
    static StringBuilder sb = new StringBuilder("I");

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        S1 = br.readLine();
        for (int i = 1; i <= N; i++) {
            sb.append("OI");
        }
        S2 = sb.toString();

        int answer = 0;
        for (int i = 0; i <= M - S2.length(); i++) {
            if (S2.equals(S1.substring(i, i + S2.length()))) {
                answer++;
            }
        }
        System.out.println(answer);
    }
}