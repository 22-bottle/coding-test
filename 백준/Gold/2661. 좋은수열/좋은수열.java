import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static int N;
	static String str = "";
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			select(i);
		}
		
	}

	private static void select(int n) {
		if (n == N) {
			System.out.println(str);
			System.exit(0);
			return;
		}
		for (int i = 1; i <= 3; i++) {
			str += i;
			if (can(n + 1)) select(n + 1);
			str = str.substring(0, n);
		}
	}

	private static boolean can(int n) {
		int r = n / 2;
		for (int i = 1; i <= r; i++) {
			if (str.substring(n - i).equals(str.substring(n - i - i, n - i)))
				return false;
		}
		return true;
	}

}
