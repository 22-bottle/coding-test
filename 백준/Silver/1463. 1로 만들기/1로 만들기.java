import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static int X, memo[], a, b, c;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		X = Integer.parseInt(br.readLine());
		memo = new int[X + 1];
		if (X >= 2) memo[2] = 1;
		if (X >= 3) memo[3] = 1;
		operate(X);
		System.out.println(memo[X]);
		
	}

	private static void operate(int n) {
		for (int i = 4; i <= n; i++) {
			a = Integer.MAX_VALUE;
			if (i % 3 == 0) {
				a = memo[i / 3] + 1;
			}
			b = Integer.MAX_VALUE;
			if (i % 2 == 0) {
				b = memo[i / 2] + 1;
			}
			c = memo[i - 1] + 1;
			a = Math.min(a, b);
			memo[i] = Math.min(a, c);
		}
	}

}