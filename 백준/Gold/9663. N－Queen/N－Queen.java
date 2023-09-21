import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static int N, answer = 0;
	static boolean[] visited1, visited2, visited3;
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		visited1 = new boolean[N];
		visited2 = new boolean[N * 2];
		visited3 = new boolean[N * 2];
		select(0);
		System.out.println(answer);
		
	}

	private static void select(int n) {
		if (n >= N) {
			answer++;
			return;
		}
		for (int i = 0; i < N; i++) {
			if (!visited1[i] && !visited2[n + i] && !visited3[n - i + N]) {
				visited1[i] = true;
				visited2[n + i] = true;
				visited3[n - i + N] = true;
				select(n + 1);
				visited1[i] = false;
				visited2[n + i] = false;
				visited3[n - i + N] = false;
			}
		}
	}

}
