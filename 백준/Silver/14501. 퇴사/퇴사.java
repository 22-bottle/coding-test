import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, T[], P[], memo[];
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		T = new int[N + 1];
		P = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
		}
		memo = new int[N + 2];
		for (int i = 1; i <= N; i++) {
			if (i + 1 < N + 2) memo[i + 1] = Math.max(memo[i + 1], memo[i]);
			if (i + T[i] < N + 2) memo[i + T[i]] = Math.max(memo[i + T[i]], memo[i] + P[i]);
		}
		System.out.println(memo[N + 1]);
		
	}
	
}
