import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] cost = new int[N][3];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				cost[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int[][] memo = new int[N][3];
		for (int i = 0; i < 3; i++) {
			memo[0][i] = cost[0][i];
		}
		for (int i = 1; i < N; i++) {
			memo[i][0] = Math.min(memo[i - 1][1], memo[i - 1][2]) + cost[i][0];
			memo[i][1] = Math.min(memo[i - 1][0], memo[i - 1][2]) + cost[i][1];
			memo[i][2] = Math.min(memo[i - 1][0], memo[i - 1][1]) + cost[i][2];
		}
		int min = Math.min(memo[N - 1][0], memo[N - 1][1]);
		min = Math.min(min, memo[N - 1][2]);
		System.out.println(min);
		
	}

}
