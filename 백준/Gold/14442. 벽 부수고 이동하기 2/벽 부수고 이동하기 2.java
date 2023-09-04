import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M, K, map[][];
	static boolean visited[][][];
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			char[] temp = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				map[i][j] = temp[j] - '0';
			}
		}
		visited = new boolean[N][M][K + 1];
		System.out.println(bfs());
		
	}
	
	private static int bfs() {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {0, 0, 0, 1});
		visited[0][0][0] = true;
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			if (cur[0] == N - 1 && cur[1] == M - 1) {
				return cur[3];
			}
			for (int d = 0; d < 4; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
				if (map[nr][nc] == 0 && !visited[nr][nc][cur[2]]) {
					q.offer(new int[] {nr, nc, cur[2], cur[3] + 1});
					visited[nr][nc][cur[2]] = true;
				} else if (map[nr][nc] == 1 && cur[2] < K && !visited[nr][nc][cur[2] + 1]) {
					q.offer(new int[] {nr, nc, cur[2] + 1, cur[3] + 1});
					visited[nr][nc][cur[2] + 1] = true;
				}
			}
		}
		return -1;
	}

}
