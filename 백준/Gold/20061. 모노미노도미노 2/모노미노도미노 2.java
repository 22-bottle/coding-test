import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, t, x, y, score, count;
	static boolean[][] board = new boolean[10][10];
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		score = 0;
		count = 0;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			t = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			moveToBlue();
			moveToGreen();
			clear();
			push();
		}
		count();
		System.out.println(score);
		System.out.println(count);

	}

	private static void moveToBlue() {
		int c = 4;
		while (c < 10 && !board[x][c]) c++;
		if (t == 2) {
			board[x][c - 2] = true;
		} else if (t == 3) {
			int c2 = 4;
			while (c2 < 10 && !board[x + 1][c2]) c2++;
			c = Integer.min(c, c2);
			board[x + 1][c - 1] = true;
		}
		board[x][c - 1] = true;
	}

	private static void moveToGreen() {
		int r = 4;
		while (r < 10 && !board[r][y]) r++;
		if (t == 2) {
			int r2 = 4;
			while (r2 < 10 && !board[r2][y + 1]) r2++;
			r = Integer.min(r, r2);
			board[r - 1][y + 1] = true;
		} else if (t == 3) {
			board[r - 2][y] = true;
		}
		board[r - 1][y] = true;
	}
	
	private static void clear() {
		int c = 9;
		while (c > 5) {
			boolean full = true;
			for (int tr = 0; tr < 4; tr++) {
				if (!board[tr][c]) full = false;
			}
			if (full) {
				score++;
				for (int tc = c; tc > 5; tc--) {
					for (int tr = 0; tr < 4; tr++) {
						board[tr][tc] = board[tr][tc - 1];
						board[tr][tc - 1] = false;
					}
				}
			}
			else c--;
		}
		
		int r = 9;
		while (r > 5) {
			boolean full = true;
			for (int tc = 0; tc < 4; tc++) {
				if (!board[r][tc]) full = false;
			}
			if (full) {
				score++;
				for (int tr = r; tr > 5; tr--) {
					for (int tc = 0; tc < 4; tc++) {
						board[tr][tc] = board[tr - 1][tc];
						board[tr - 1][tc] = false;
					}
				}
			}
			else r--;
		}
	}
	
	private static void push() {
		int cnt = 0;
		for (int c = 4; c < 6; c++) {
			for (int r = 0; r < 4; r++) {
				if (board[r][c]) {
					cnt++;
					break;
				}
			}
		}
		if (cnt != 0) {
			for (int c = 9 - cnt; c >= 6 - cnt; c--) {
				for (int r = 0; r < 4; r++) {
					board[r][c + cnt] = board[r][c];
					board[r][c] = false;
				}
			}
			cnt = 0;
		}
		for (int r = 4; r < 6; r++) {
			for (int c = 0; c < 4; c++) {
				if (board[r][c]) {
					cnt++;
					break;
				}
			}
		}
		if (cnt != 0) {
			for (int r = 9 - cnt; r >= 6 - cnt; r--) {
				for (int c = 0; c < 4; c++) {
					board[r + cnt][c] = board[r][c];
					board[r][c] = false;
				}
			}
		}
	}
	
	private static void count() {
		for (int r = 0; r < 4; r++) {
			for (int c = 6; c < 10; c++) {
				if (board[r][c]) count++;
				if (board[c][r]) count++;
			}
		}
	}

}
