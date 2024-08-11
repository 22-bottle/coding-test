import java.io.*;
import java.util.*;

public class Main {
    static int N, M, V;
    static List<Integer>[] adjL;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        adjL = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++)
            adjL[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adjL[a].add(b);
            adjL[b].add(a);
        }

        for (int i = 1; i <= N; i++)
            Collections.sort(adjL[i]);

        visited = new boolean[N + 1];
        dfs(V);
        sb.append("\n");
        bfs();
        System.out.println(sb);

    }

    public static void dfs(int n) {
        visited[n] = true;
        sb.append(n).append(" ");
        for (int i = 0; i < adjL[n].size(); i++) {
            if (visited[adjL[n].get(i)]) continue;
            dfs(adjL[n].get(i));
        }
    }

    public static void bfs() {
        visited = new boolean[N + 1];
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(V);
        visited[V] = true;
        while (!q.isEmpty()) {
            int cur = q.poll();
            sb.append(cur).append(" ");
            for (int i = 0; i < adjL[cur].size(); i++) {
                if (visited[adjL[cur].get(i)]) continue;
                q.offer(adjL[cur].get(i));
                visited[adjL[cur].get(i)] = true;
            }
        }
    }
}