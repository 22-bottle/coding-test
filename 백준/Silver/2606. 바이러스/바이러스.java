import java.io.*;
import java.util.*;

public class Main {
    static List<Integer>[] adjL;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        adjL = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) adjL[i] = new ArrayList<>();
        visited = new boolean[N + 1];

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adjL[a].add(b);
            adjL[b].add(a);
        }

        int count = 0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        visited[1] = true;
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (Integer i : adjL[cur]) {
                if (visited[i]) continue;
                q.offer(i);
                visited[i] = true;
                count++;
            }
        }
        System.out.println(count);
    }
}