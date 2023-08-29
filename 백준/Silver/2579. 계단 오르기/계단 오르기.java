import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	static int N, score[], memo[][];

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		score = new int[N];
		for (int i = 0; i < N; i++) {
			score[i] = Integer.parseInt(br.readLine());
		}
		memo = new int[N][3];
		memo[0][1] = score[0];
		memo[0][2] = score[0];
		for (int i = 1; i < N; i++) {
			memo[i][0] = Math.max(memo[i - 1][1], memo[i - 1][2]);
			memo[i][1] = memo[i - 1][0] + score[i];
			memo[i][2] = memo[i - 1][1] + score[i];
		}
		System.out.println(Math.max(memo[N - 1][1], memo[N - 1][2]));
		
	}

}