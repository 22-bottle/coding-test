import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static int[][] sudoku;
	static boolean answer;
	static boolean[] isVisited;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sudoku = new int[9][9];
			isVisited = new boolean[10];
			for (int i = 0; i < 9; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < 9; j++) {
					sudoku[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			answer = true;
			check_row();
			if (answer) check_column();
			if (answer) check_square();
			
			if (answer) System.out.printf("#%d 1\n", tc);
			else System.out.printf("#%d 0\n", tc);
		}
	}
	
	private static void check_row() {
		for (int i = 0; i < 9; i++) {
			if (!answer) break;
			for (int j = 1; j < 10; j++) {
				isVisited[j] = false;				
			}
			
			for (int j = 0; j < 9; j++) {
				if (isVisited[sudoku[i][j]]) answer = false;
				else isVisited[sudoku[i][j]] = true;
			}
		}
	}
	
	private static void check_column() {
		for (int j = 0; j < 9; j++) {
			if (!answer) break;
			for (int i = 1; i < 10; i++) {
				isVisited[i] = false;
			}
			
			for (int i = 0; i < 9; i++) {
				if (isVisited[sudoku[i][j]]) answer = false;
				else isVisited[sudoku[i][j]] = true;
			}
		}
	}
	
	private static void check_square() {
		for (int i = 0; i < 9; i++) {
			if (!answer) break;
			for (int j = 1; j < 10; j++) {
				isVisited[j] = false;
			}
			
			int sr = (i / 3) * 3;
			int sc = (i % 3) * 3;
			for (int j = 0; j < 9; j++) {
				int wr = (j / 3);
				int wc = (j % 3);
				if (isVisited[sudoku[sr + wr][sc + wc]]) answer = false;
				else isVisited[sudoku[sr + wr][sc + wc]] = true;
			}
		}
	}

}