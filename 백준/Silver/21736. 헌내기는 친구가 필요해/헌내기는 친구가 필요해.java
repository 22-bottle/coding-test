import java.io.*;
import java.util.*;

public class Main {
    static int N, M, count = 0;
    static char[][] map;
    static boolean[][] visited;
    static Queue<int[]> q = new ArrayDeque<>();
    static int[] dr = new int[] {-1, 1, 0, 0};
    static int[] dc = new int[] {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        visited = new boolean[N][M];
        int curR = -1, curC = -1;
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j);
                if (map[i][j] == 'I') {
                    curR = i; curC = j;
                }
            }
        }

        q.offer(new int[] {curR, curC});
        visited[curR][curC] = true;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int d = 0; d < 4; d++) {
                int nextR = cur[0] + dr[d];
                int nextC = cur[1] + dc[d];
                if (!canMove(nextR, nextC)) continue;
                if (map[nextR][nextC] == 'P') count++;
                q.offer(new int[] {nextR, nextC});
                visited[nextR][nextC] = true;
            }
        }
        System.out.println(count == 0 ? "TT" : count);
    }

    public static boolean canMove(int r, int c) {
        if (r < 0 || r >= N || c < 0 || c >= M) return false;
        if (map[r][c] == 'X') return false;
        return !visited[r][c];
    }
}