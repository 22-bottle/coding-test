import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
	
	static char[][] board = new char[12][6];
	static int answer = 0;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 12; i++) {
			board[i] = br.readLine().toCharArray();
		}
		while (true) {
			boolean chain = false;
			for (int i = 0; i < 12; i++) {
				for (int j = 0; j < 6; j++) {
					if (board[i][j] != '.') {
						if (bfs(i, j)) {
							chain = true;
						}
					}
				}
			}
			move();
			if (chain) answer++;
			else break;
		}
		System.out.println(answer);
		
	}

	private static boolean bfs(int r, int c) {
		char target = board[r][c];
		Queue<int[]> q = new ArrayDeque<>();		
		q.offer(new int[] {r, c});
		boolean[][] visited = new boolean[12][6];
		visited[r][c] = true;
		int cnt = 1;
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			for (int d = 0; d < 4; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				if (nr < 0 || nr >= 12 || nc < 0 || nc >= 6) continue;
				if (!visited[nr][nc] && board[nr][nc] == target) {
					q.offer(new int[] {nr, nc});
					visited[nr][nc] = true;
					cnt++;
				}
			}
		}
		if (cnt >= 4) {
			for (int i = 0; i < 12; i++) {
				for (int j = 0; j < 6; j++) {
					if (visited[i][j]) {
						board[i][j] = '.';
					}
				}
			}
			return true;
		}
		return false;
	}
	
	private static void move() {
		for (int j = 0; j < 6; j++) {
			for (int start = 11; start >= 0; start--) {
				int i = start;
				while (i >= 0 && board[i][j] == '.') {
					i--;
				}
				if (i < 0) {
					break;
				} else if (i != start) {
					board[start][j] = board[i][j];
					board[i][j] = '.';
				}
			}
		}
	}

}
