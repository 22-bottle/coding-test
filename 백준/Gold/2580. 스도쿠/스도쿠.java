import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] board = new int[9][9];
	static boolean flag = false;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 9; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		select(0, 0);
		
	}
	
	private static void select(int r, int c) {
		if (r == 9) {
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					System.out.print(board[i][j] + " ");
				}
				System.out.println();
			}
			System.exit(0);
		}
		if (board[r][c] == 0) {
			for (int i = 1; i <= 9; i++) {
				if (!search1(r, i)) continue;
				if (!search2(c, i)) continue;
				if (!search3(r, c, i)) continue;
				board[r][c] = i;
				if (c + 1 >= 9) select(r + 1, 0);
				else select(r, c + 1);
				board[r][c] = 0;
				if (flag) break;
			}
		} else {
			if (c + 1 >= 9) select(r + 1, 0);
			else select(r, c + 1);
		}
	}
	
	private static boolean search1(int r, int n) {
		for (int i = 0; i < 9; i++) {
			if (board[r][i] == n) return false;
		}
		return true;
	}
	
	private static boolean search2(int c, int n) {
		for (int i = 0; i < 9; i++) {
			if (board[i][c] == n) return false;
		}
		return true;
	}
	
	private static boolean search3(int r, int c, int n) {
		int start_r = r - (r % 3);
		int start_c = c - (c % 3);
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (board[start_r + i][start_c + j] == n) return false;
			}
		}
		return true;
	}

}
