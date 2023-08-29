import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] memo = new int[N + 2];
		memo[1] = 1;
		memo[2] = 2;
		for (int i = 3; i <= N; i++) {
			memo[i] = (memo[i - 1] + memo[i - 2]) % 10007;
		}
		System.out.println(memo[N]);
		
	}

}
