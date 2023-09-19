import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M, board[][], cnt = 0;
	static Queue<int[]> tomatoes = new ArrayDeque<>();
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		board = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (board[i][j] == 1) tomatoes.offer(new int[] {i, j, 0});
				else if (board[i][j] == 0) cnt++;
			}
		}
		int[] cur = null;
		while (!tomatoes.isEmpty()) {
			cur = tomatoes.poll();
			for (int d = 0; d < 4; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
				if (board[nr][nc] == 0) {
					tomatoes.offer(new int[] {nr, nc, cur[2] + 1});
					board[nr][nc] = 1;
					cnt--;
				}
			}
		}
		if (cnt > 0) System.out.println(-1);
		else System.out.println(cur[2]);
	}

}
