import java.io.*;
import java.util.PriorityQueue;

public class Main {
    static int N;
    static PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
        if (Math.abs(o1) == Math.abs(o2)) return o1 - o2;
        return Math.abs(o1) - Math.abs(o2);
    });

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            if (x == 0) {
                if (pq.isEmpty()) sb.append(0).append("\n");
                else sb.append(pq.poll()).append("\n");
            } else {
                pq.offer(x);
            }
        }
        System.out.println(sb);
    }
}