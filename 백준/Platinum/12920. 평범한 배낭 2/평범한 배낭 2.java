import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, M, V[], C[], v, c, k, memo[];
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = new int[N * 10000 + 1];
		C = new int[N * 10000 + 1];
		int cnt = 1;
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			v = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			int v_copy = v;
			int c_copy = c;
			for (int j = 0; k > (1 << j); j++) {
				V[cnt] = v_copy;
				C[cnt++] = c_copy;
				v_copy += v_copy;
				c_copy += c_copy;
				k -= (1 << j);
			}
			if (k > 0) {
				V[cnt] = v * k;
				C[cnt++] = c * k;
			}
		}
		memo = new int[M + 1];
		for (int i = 1; i < cnt; i++) {
			for (int j = M; j >= V[i]; j--) {
				memo[j] = Math.max(memo[j], C[i] + memo[j - V[i]]);
			}
		}
		System.out.println(memo[M]);
		
	}

}
