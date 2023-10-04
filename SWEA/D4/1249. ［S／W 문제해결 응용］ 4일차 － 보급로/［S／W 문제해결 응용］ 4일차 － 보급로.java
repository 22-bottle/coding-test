import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Solution {

	static int T, N, map[][], answer, visited[][];
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				String temp = br.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = temp.charAt(j) - '0';
				}
			}
			answer = Integer.MAX_VALUE;
			visited = new int[N][N];
			for (int i = 0; i < N; i++) {
				Arrays.fill(visited[i], Integer.MAX_VALUE);
			}
			bfs();
			System.out.printf("#%d %d\n", tc, answer);
		}
		
	}
	
	private static void bfs() {
		Queue<int[]> q  = new ArrayDeque<>();
		q.offer(new int[] {0, 0, 0});
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			if (cur[0] == N - 1 && cur[1] == N - 1) {
				answer = Math.min(answer, cur[2]);
			}
			for (int d = 0; d < 4; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
				int nt = cur[2] + map[nr][nc];
				if (visited[nr][nc] > nt) {
					q.offer(new int[] {nr, nc, nt});
					visited[nr][nc] = nt;					
				}
			}
		}
	}

}
