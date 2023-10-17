import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, M, board[][], answer = 0;
	static boolean[][] visited;
	static int[] dr = {1, 0, -1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				visited[i][j] = true;
				select(i, j, 1, board[i][j]);
				visited[i][j] = false;
			}
		}
		System.out.println(answer);
		
	}

	private static void select(int r, int c, int n, int sum) {
		if (n == 4) {
			answer = Math.max(answer, sum);
			return;
		}
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if (nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc]) continue;
			if (!visited[nr][nc]) {
				if (n == 2) {
					visited[nr][nc] = true;
					select(r, c, n + 1, sum + board[nr][nc]);
					visited[nr][nc] = false;
				}
				visited[nr][nc] = true;
				select(nr, nc, n + 1, sum + board[nr][nc]);
				visited[nr][nc] = false;
			}
		}
	}

}
