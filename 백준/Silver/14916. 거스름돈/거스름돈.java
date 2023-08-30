import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] memo = new int[n + 5];
		memo[1] = Integer.MAX_VALUE;
		memo[2] = 1;
		memo[3] = Integer.MAX_VALUE;
		memo[4] = 2;
		memo[5] = 1;
		for (int i = 6; i <= n; i++) {
			memo[i] = Math.min(memo[i - 2], memo[i - 5]) + 1;
		}
		System.out.println(memo[n] != Integer.MAX_VALUE ? memo[n] : -1);
		
	}

}
