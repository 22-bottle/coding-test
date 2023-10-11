import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M, K, mat[][], commands[][], sel[], test[][], answer = Integer.MAX_VALUE;
	static boolean visited[];

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		mat = new int[N + 1][M + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				mat[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		commands = new int[K][3];
		for (int k = 0; k < K; k++) {
			st = new StringTokenizer(br.readLine());
			commands[k][0] = Integer.parseInt(st.nextToken());
			commands[k][1] = Integer.parseInt(st.nextToken());
			commands[k][2] = Integer.parseInt(st.nextToken());
		}
		sel = new int[K];
		visited = new boolean[K];
		perm(0);
		System.out.println(answer);
		
	}

	private static void perm(int idx) {
		if (idx == K) {
			simulation();
			answer = Math.min(answer, scoring());
			return;
		}
		for (int i = 0; i < K; i++) {
			if (visited[i]) continue;
			sel[idx] = i;
			visited[i] = true;
			perm(idx + 1);
			visited[i] = false;
		}
	}

	private static void simulation() {
		test = new int[N + 1][M + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				test[i][j] = mat[i][j];
			}
		}
		for (int k = 0; k < K; k++) {
			int com = sel[k];
			int r = commands[com][0];
			int c = commands[com][1];
			int s = commands[com][2];
			for (int dif = s; dif > 0; dif--) {
				int t = test[r - dif][c - dif];
				for (int i = r - dif + 1; i <= r + dif; i++) {
					test[i - 1][c - dif] = test[i][c - dif];
				}
				for (int i = c - dif + 1; i <= c + dif; i++) {
					test[r + dif][i - 1] = test[r + dif][i];
				}
				for (int i = r + dif - 1; i >= r - dif; i--) {
					test[i + 1][c + dif] = test[i][c + dif];
				}
				for (int i = c + dif - 1; i >= c - dif; i--) {
					test[r - dif][i + 1] = test[r - dif][i];
				}
				test[r - dif][c - dif + 1] = t;
			}
		}
	}
	
	private static int scoring() {
		int score = Integer.MAX_VALUE;
		for (int i = 1; i <= N; i++) {
			int sum = 0;
			for (int j = 1; j <= M; j++) {
				sum += test[i][j];
			}
			score = Math.min(score, sum);
		}
		return score;
	}

}
