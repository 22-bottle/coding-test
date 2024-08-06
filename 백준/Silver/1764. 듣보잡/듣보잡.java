import java.io.*;
import java.util.*;

public class Main {
    static Set<String> set = new HashSet<>();
    static PriorityQueue<String> pq = new PriorityQueue<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            set.add(br.readLine());
        }
        for (int i = 0; i < M; i++) {
            String name = br.readLine();
            if (set.contains(name)) {
                pq.add(name);
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(pq.size()).append("\n");
        while (!pq.isEmpty()) {
            sb.append(pq.poll()).append("\n");
        }
        System.out.println(sb);
    }
}