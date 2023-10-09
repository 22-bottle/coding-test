import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M, T, map[][], answer = Integer.MAX_VALUE;
	static boolean[][][] visited;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		visited = new boolean[N][M][2];
		bfs();
		System.out.println(answer <= T ? answer : "Fail");
		
	}

	private static void bfs() {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {0, 0, 0, 0});
		visited[0][0][0] = true;
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int gram = cur[2];
			if (cur[0] == N - 1 && cur[1] == M - 1) {
				answer = Math.min(answer, cur[3]);
			}
			for (int d = 0; d < 4; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
				if (gram == 0 && !visited[nr][nc][gram] && map[nr][nc] != 1) {
					if (map[nr][nc] == 2) {
						q.offer(new int[] {nr, nc, 1, cur[3] + 1});
						visited[nr][nc][1] = true;
					} else {
						q.offer(new int[] {nr, nc, gram, cur[3] + 1});
						visited[nr][nc][gram] = true;
					}
				} else if (gram == 1 && !visited[nr][nc][gram]) {
					q.offer(new int[] {nr, nc, gram, cur[3] + 1});
					visited[nr][nc][gram] = true;
				}
			}
		}
	}

}
