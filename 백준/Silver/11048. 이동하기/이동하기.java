import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;

public class Main {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] maze = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				maze[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int[][] memo = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (i == 0 && j == 0) memo[i][j] = maze[0][0];
				else if (i == 0) memo[i][j] = memo[i][j - 1] + maze[i][j];
				else if (j == 0) memo[i][j] = memo[i - 1][j] + maze[i][j];
				else {
					memo[i][j] = Math.max(memo[i - 1][j], memo[i][j - 1]);
					memo[i][j] = Math.max(memo[i][j], memo[i - 1][j - 1]) + maze[i][j];
				}
			}
		}
		System.out.println(memo[N - 1][M - 1]);
		
	}

}
