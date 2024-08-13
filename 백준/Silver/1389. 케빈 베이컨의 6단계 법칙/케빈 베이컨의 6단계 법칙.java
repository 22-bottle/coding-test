import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static List<Integer>[] adjL;
    static Queue<int[]> q;
    static PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        adjL = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adjL[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adjL[a].add(b);
            adjL[b].add(a);
        }

        for (int i = 1; i <= N; i++) {
            start(i);
        }
        System.out.println(pq.poll()[0]);
    }

    public static void start(int n) {
        int[] cost = new int[N + 1];
        Arrays.fill(cost, Integer.MAX_VALUE);
        q = new ArrayDeque<>();
        q.offer(new int[] {n, 0});
        cost[n] = 0;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int i : adjL[cur[0]]) {
                if (cost[i] <= cur[1] + 1) continue;
                q.offer(new int[] {i, cur[1] + 1});
                cost[i] = cur[1] + 1;
            }
        }
        int sum = 0;
        for (int i = 1; i <= N; i++) {
           sum += cost[i];
        }
        pq.offer(new int[] {n, sum});
    }
}