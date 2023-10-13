import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, M, ladders[] = new int[101], snakes[] = new int[101], memo[] = new int[101];
	static boolean[] start = new boolean[101];
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			ladders[s] = e;
			start[s] = true;
		}
		for (int j = 0; j < M; j++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			snakes[s] = e;
			start[s] = true;
		}
		Arrays.fill(memo, Integer.MAX_VALUE);
		memo[1] = 0;
		for (int i = 2; i <= 100; i++) {
			if (i - 1 > 0 && !start[i - 1]) memo[i] = Math.min(memo[i], memo[i - 1] + 1);
			if (i - 2 > 0 && !start[i - 2]) memo[i] = Math.min(memo[i], memo[i - 2] + 1);
			if (i - 3 > 0 && !start[i - 3]) memo[i] = Math.min(memo[i], memo[i - 3] + 1);
			if (i - 4 > 0 && !start[i - 4]) memo[i] = Math.min(memo[i], memo[i - 4] + 1);
			if (i - 5 > 0 && !start[i - 5]) memo[i] = Math.min(memo[i], memo[i - 5] + 1);
			if (i - 6 > 0 && !start[i - 6]) memo[i] = Math.min(memo[i], memo[i - 6] + 1);
			
			if (ladders[i] != 0) {
				memo[ladders[i]] = Math.min(memo[ladders[i]], memo[i]);
			} else if (snakes[i] != 0) {
				if (memo[snakes[i]] > memo[i]) {
					memo[snakes[i]] = memo[i];
					i = snakes[i];
				}
			}
		}
		System.out.println(memo[100]);
		
	}

}
