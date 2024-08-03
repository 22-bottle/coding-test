import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] scores = new int[N];
        for (int i = 0; i < N; i++) {
            scores[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(scores);
        int except = Math.round((float)N * 0.15f);
        int sum = 0;
        for (int i = except; i < N - except; i++) {
            sum += scores[i];
        }
        System.out.println(Math.round((float)sum / (N - except * 2)));
    }
}