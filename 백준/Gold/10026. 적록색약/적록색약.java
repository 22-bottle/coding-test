import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    
    static int N, cnt;
    static char[][] grid;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static boolean[][] visited;
    static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        
        sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        grid = new char[N][N];
        for (int i = 0; i < N; i++) {
            grid[i] = br.readLine().toCharArray();
        }
        count(false);
        count(true);
        System.out.println(sb);
        
    }

    private static void count(boolean weak) {
        cnt = 0;
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    char color = grid[i][j];
                    cnt++;
                    Queue<int[]> q = new ArrayDeque<>();
                    q.offer(new int[] {i, j});
                    visited[i][j] = true;
                    while (!q.isEmpty()) {
                        int[] cur = q.poll();
                        for (int d = 0; d < 4; d++) {
                            int nr = cur[0] + dr[d];
                            int nc = cur[1] + dc[d];
                            if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
                            if (visited[nr][nc]) continue;
                            if (weak) {
                                if (grid[nr][nc] == color || (grid[nr][nc] == 'R' && color == 'G') || (grid[nr][nc] == 'G' && color == 'R')) {
                                    q.offer(new int[] {nr, nc});
                                    visited[nr][nc] = true;                                    
                                }
                            } else {
                                if (grid[nr][nc] == color) {
                                    q.offer(new int[] {nr, nc});
                                    visited[nr][nc] = true;    
                                }
                            }
                        }
                    }
                }
            }
        }
        sb.append(cnt + " ");
    }

}