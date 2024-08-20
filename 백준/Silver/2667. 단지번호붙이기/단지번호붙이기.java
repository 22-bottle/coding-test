import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static List<Integer> list = new ArrayList<>();
    static int[] dr = new int[] {-1, 1, 0, 0};
    static int[] dc = new int[] {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        int num = 2;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1)
                    numbering(i, j, num++);
            }
        }
        Collections.sort(list);

        StringBuilder sb = new StringBuilder().append(num - 2).append("\n");
        for (int i : list) sb.append(i).append("\n");
        System.out.println(sb);
    }

    public static void numbering(int r, int c, int num) {
        visited = new boolean[N][N];
        Queue<int[]> q = new ArrayDeque<>();

        map[r][c] = num;
        q.offer(new int[] {r, c});
        visited[r][c] = true;
        int count = 1;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int d = 0; d < 4; d++) {
                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d];
                if (!canMove(nr, nc)) continue;
                map[nr][nc] = num;
                q.offer(new int[] {nr, nc});
                visited[nr][nc] = true;
                count++;
            }
        }
        list.add(count);
    }

    public static boolean canMove(int r, int c) {
        if (r < 0 || r >= N || c < 0 || c >= N) return false;
        if (map[r][c] == 0) return false;
        return !visited[r][c];
    }
}