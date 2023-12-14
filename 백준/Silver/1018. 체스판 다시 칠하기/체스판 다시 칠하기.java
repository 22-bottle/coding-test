import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, M, answer = Integer.MAX_VALUE;
	static char[][] board;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new char[N][M];
		for (int i = 0; i < N; i++) {
			board[i] = br.readLine().toCharArray();
		}

		for (int i = 0; i <= N - 8; i++) {
			for (int j = 0; j <= M - 8; j++) {
				check(i, j);
			}
		}
		System.out.println(answer);
		
	}

	private static void check(int r, int c) {
		int cnt = 0;
		boolean white = true;
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (white && board[r + i][c + j] == 'W') cnt++;
				else if (!white && board[r + i][c + j] == 'B') cnt++;
				white = !white;
			}
			white = !white;
		}
		answer = Integer.min(answer, Integer.min(cnt, 64 - cnt));
	}

}
