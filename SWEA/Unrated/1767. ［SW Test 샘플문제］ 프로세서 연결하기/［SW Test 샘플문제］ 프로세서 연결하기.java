import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

	static int T, N, board[][], min_cnt, max_core, cur_cnt, cur_core;
	static List<int[]> cores;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static boolean[][] visited;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			min_cnt = Integer.MAX_VALUE;
			max_core = 0;
			N = Integer.parseInt(br.readLine());
			board = new int[N][N];
			cores = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
					if (board[i][j] == 1 && i != 0 && i != N - 1 && j != 0 && j != N - 1)
						cores.add(new int[] { i, j });
				}
			}
			visited = new boolean[N][N];
			cur_cnt = 0;
			cur_core = 0;
			start(0);
			System.out.printf("#%d %d\n", tc, min_cnt);
		}

	}

	private static void start(int n) {
		if (n == cores.size()) {
			if (cur_core > max_core) {
				max_core = cur_core;
				min_cnt = cur_cnt;
			} else if (cur_core == max_core) {
				min_cnt = Math.min(min_cnt, cur_cnt);
			}
			return;
		}
		for (int d = 0; d < 4; d++) {
			boolean can = true;
			int nr = cores.get(n)[0] + dr[d];
			int nc = cores.get(n)[1] + dc[d];
			while (nr >= 0 && nr < N && nc >= 0 && nc < N) {
				if (board[nr][nc] == 1 || visited[nr][nc]) {
					can = false;
					break;
				}
				nr += dr[d];
				nc += dc[d];
			}
			if (can) {
				nr = cores.get(n)[0] + dr[d];
				nc = cores.get(n)[1] + dc[d];
				while (nr >= 0 && nr < N && nc >= 0 && nc < N) {
					visited[nr][nc] = true;
					cur_cnt++;
					nr += dr[d];
					nc += dc[d];
				}
				cur_core++;
			}
			start(n + 1);
			if (can) {
				nr = cores.get(n)[0] + dr[d];
				nc = cores.get(n)[1] + dc[d];
				while (nr >= 0 && nr < N && nc >= 0 && nc < N) {
					visited[nr][nc] = false;
					cur_cnt--;
					nr += dr[d];
					nc += dc[d];
				}
				cur_core--;
			}
		}
	}

}
