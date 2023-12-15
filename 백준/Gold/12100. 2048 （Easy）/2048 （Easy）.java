import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, original[][], board[][], max = 0;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		original = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				original[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		board = new int[N][N];
		for (int i = 0; i < 4; i++) {
			init();
			move(0, i);
		}
		if (N == 1) System.out.println(board[0][0]);
		else System.out.println(max);
		
	}

	private static void init() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				board[i][j] = original[i][j];
			}
		}
	}

	private static void move(int depth, int dir) {
		if (depth == 5) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					max = Integer.max(max, board[i][j]);
				}
			}
			return;
		}
		for (int i = 0; i < dir; i++) {
			rotate();
		}
		add();
		for (int i = 0; i < 4 - dir; i++) {
			rotate();
		}
		for (int i = 0; i < 4; i++) {
			int[][] temp = new int[N][N];
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					temp[j][k] = board[j][k];
				}
			}
			move(depth + 1, i);
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					board[j][k] = temp[j][k];
				}
			}
		}
		
	}

	private static void rotate() {
		int[][] copy = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				copy[i][j] = board[i][j];
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				board[j][N - 1 - i] = copy[i][j];
			}
		}
	}
	
	private static void add() {
		for (int j = 0; j < N; j++) {
			int cnt = 0;
			for (int top = 0; top < N; top++) {
				if (board[top][j] == 0) continue;
				for (int bottom = top + 1; bottom <= N; bottom++) {
					if (bottom == N) {
						board[cnt][j] = board[top][j];
						if (cnt != top) board[top][j] = 0;
						break;
					}
					if (board[bottom][j] == 0) continue;
					int cur = board[top][j];
					board[top][j] = 0;
					if (cur == board[bottom][j]) {
						board[bottom][j] = 0;
						board[cnt++][j] = cur * 2;
					} else {
						board[cnt++][j] = cur;
					}
					break;
				}
			}
		}
	}

}
