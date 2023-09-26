import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int T, N, seq[], memo[];
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			seq = new int[N + 1];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++) {
				seq[i] = Integer.parseInt(st.nextToken());
			}
			int max = 0;
			memo = new int[N + 1];
			for (int i = 1; i <= N; i++) {
				memo[i] = 1;
				for (int j = 1; j < i; j++) {
					if (seq[j] < seq[i]) {
						memo[i] = Math.max(memo[i], memo[j] + 1);
					}
				}
				max = Math.max(max, memo[i]);
			}
			System.out.printf("#%d %d\n", tc, max);
		}
	}

}
