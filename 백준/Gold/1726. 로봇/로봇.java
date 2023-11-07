import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M, map[][], r, c, d;
	static int[] dr = {0, 0, 0, 1, -1};
	static int[] dc = {0, 1, -1, 0, 0};
	static boolean[][][] visited;
	static Queue<int[]> q = new ArrayDeque<>();

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N + 1][M + 1];
		visited = new boolean[N + 1][M + 1][5];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		q.offer(new int[] {r, c, d, 0});
		visited[r][c][d] = true;
		
		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		int[] cur = null;
		while (!q.isEmpty()) {
			cur = q.poll();
			if (cur[0] == r && cur[1] == c && cur[2] == d) break;
			for (int nd = 1; nd < 5; nd++) {
				int nr = cur[0];
				int nc = cur[1];
				if (nd == cur[2]) {
					for (int i = 1; i <= 3; i++) {
						nr += dr[nd];
						nc += dc[nd];
						if (nr <= 0 || nr > N || nc <= 0 || nc > M) continue;
						if (map[nr][nc] == 1) break;
						if (!visited[nr][nc][nd]) {
							q.offer(new int[] {nr, nc, nd, cur[3] + 1});
							visited[nr][nc][nd] = true;
						}
					}
				} else if (dr[nd] + dr[cur[2]] != 0 || dc[nd] + dc[cur[2]] != 0) {
					if (!visited[nr][nc][nd]) {
						q.offer(new int[] {nr, nc, nd, cur[3] + 1});
						visited[nr][nc][nd] = true;
					}
				}
			}
		}
		System.out.println(cur[3]);
		
	}

}
