import java.io.*;
import java.util.*;

public class Main {
    static int N, M, r, c;
    static int[][] map, cost;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static Queue<int[]> q = new ArrayDeque<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        cost = new int[N][M];
        for (int i = 0; i < N; i++) {
            Arrays.fill(cost[i], Integer.MAX_VALUE);
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    r = i; c = j;
                }
            }
        }

        q.offer(new int[] {r, c, 0});
        cost[r][c] = 0;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int d = 0; d < 4; d++) {
                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d];
                if (!canMove(nr, nc, cur[2] + 1)) continue;
                q.offer(new int[] {nr, nc, cur[2] + 1});
                cost[nr][nc] = cur[2] + 1;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) sb.append(0).append(" ");
                else sb.append(cost[i][j] == Integer.MAX_VALUE ? -1 : cost[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static boolean canMove(int r, int c, int price) {
        if (r < 0 || r >= N || c < 0 || c >= M) return false;
        if (map[r][c] == 0) return false;
        return cost[r][c] > price;
    }
}