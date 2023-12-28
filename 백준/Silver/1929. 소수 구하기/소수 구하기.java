import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		for (int i = M; i <= N; i++) {
			if (isPrime(i)) System.out.println(i);
		}
		
	}

	private static boolean isPrime(int n) {
		if (n == 1) return false;
		if (n == 2) return true;
		for (int i = 2; i <= Math.sqrt(n) + 1; i++) {
			if (n % i == 0) return false;
		}
		return true;
	}

}