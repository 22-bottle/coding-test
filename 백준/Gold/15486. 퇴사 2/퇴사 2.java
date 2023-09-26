import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, T[], P[], memo[][];
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		T = new int[N + 1];
		P = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			T[i] = Integer.parseInt(st.nextToken()) - 1;
			P[i] = Integer.parseInt(st.nextToken());
		}
		memo = new int[2][N + 1];
		for (int d = 1; d <= N; d++) {
			memo[0][d] = Math.max(memo[0][d - 1], memo[1][d - 1]);
			if (d + T[d] <= N) memo[1][d + T[d]] = Math.max(memo[1][d + T[d]], P[d] + memo[0][d]);
		}
		System.out.println(Math.max(memo[0][N], memo[1][N]));
		
	}

}
