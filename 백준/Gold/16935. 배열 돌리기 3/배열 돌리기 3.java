import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, M, R, mat1[][], mat2[][];
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int max = Math.max(N, M);
		R = Integer.parseInt(st.nextToken());
		mat1 = new int[max][max];
		mat2 = new int[max][max];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				mat1[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < R; i++) {
			int cmd = Integer.parseInt(st.nextToken());
			if (i % 2 == 0) {
				switch (cmd) {
					case 1: move1(mat1, mat2); break;
					case 2: move2(mat1, mat2); break;
					case 3: switchNM(); move3(mat1, mat2); break;
					case 4: switchNM(); move4(mat1, mat2); break;
					case 5: move5(mat1, mat2); break;
					case 6: move6(mat1, mat2); break;
				}
			} else {
				switch (cmd) {
					case 1: move1(mat2, mat1); break;
					case 2: move2(mat2, mat1); break;
					case 3: switchNM(); move3(mat2, mat1); break;
					case 4: switchNM(); move4(mat2, mat1); break;
					case 5: move5(mat2, mat1); break;
					case 6: move6(mat2, mat1); break;
				}
			}
		}
		if (R % 2 == 0) print(mat1);
		else print(mat2);
		
	}
	
	private static void switchNM() {
		int temp = N;
		N = M;
		M = temp;
	}

	private static void move1(int[][] from, int[][] to) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				to[i][j] = from[N - 1 - i][j];
			}
		}
	}

	private static void move2(int[][] from, int[][] to) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				to[i][j] = from[i][M - 1 - j];
			}
		}
	}
	
	private static void move3(int[][] from, int[][] to) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				to[i][j] = from[M - 1 - j][i];
			}
		}
	}
	
	private static void move4(int[][] from, int[][] to) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				to[i][j] = from[j][N - 1 - i];
			}
		}
	}
	
	private static void move5(int[][] from, int[][] to) {
		int r_half = N / 2;
		int c_half = M / 2;
		for (int i = 0; i < r_half; i++) {
			for (int j = 0; j < c_half; j++) {
				to[i][j] = from[i + r_half][j];
			}
		}
		for (int i = 0; i < r_half; i++) {
			for (int j = c_half; j < M; j++) {
				to[i][j] = from[i][j - c_half];
			}
		}
		for (int i = r_half; i < N; i++) {
			for (int j = c_half; j < M; j++) {
				to[i][j] = from[i - r_half][j];
			}
		}
		for (int i = r_half; i < N; i++) {
			for (int j = 0; j < c_half; j++) {
				to[i][j] = from[i][j + c_half];
			}
		}
	}
	
	private static void move6(int[][] from, int[][] to) {
		int r_half = N / 2;
		int c_half = M / 2;
		for (int i = 0; i < r_half; i++) {
			for (int j = 0; j < c_half; j++) {
				to[i][j] = from[i][j + c_half];
			}
		}
		for (int i = 0; i < r_half; i++) {
			for (int j = c_half; j < M; j++) {
				to[i][j] = from[i + r_half][j];
			}
		}
		for (int i = r_half; i < N; i++) {
			for (int j = c_half; j < M; j++) {
				to[i][j] = from[i][j - c_half];
			}
		}
		for (int i = r_half; i < N; i++) {
			for (int j = 0; j < c_half; j++) {
				to[i][j] = from[i - r_half][j];
			}
		}
	}
	
	private static void print(int[][] mat) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(mat[i][j] + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
