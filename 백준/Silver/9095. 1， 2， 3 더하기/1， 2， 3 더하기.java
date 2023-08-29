import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static int T, memo[];
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		memo = new int[12];
		memo[1] = 1;
		memo[2] = 2;
		memo[3] = 4;
		calc();
		for (int i = 0; i < T; i++) {
			System.out.println(memo[Integer.parseInt(br.readLine())]);
		}
		
	}

	private static void calc() {
		for (int i = 4; i <= 11; i++) {
			memo[i] = memo[i - 1] + memo[i - 2] + memo[i - 3];
		}
	}

}
