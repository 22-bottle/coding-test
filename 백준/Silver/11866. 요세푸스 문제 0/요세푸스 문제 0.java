import java.io.*;
import java.util.*;

public class Main {
    static Queue<Integer> q = new ArrayDeque<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= N; i++) {
            q.offer(i);
        }
        int K = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder("<");
        while (q.size() > 1) {
            for (int i = 0; i < K - 1; i++) {
                q.offer(q.poll());
            }
            sb.append(q.poll()).append(", ");
        }
        sb.append(q.poll()).append(">");
        System.out.println(sb);
    }
}