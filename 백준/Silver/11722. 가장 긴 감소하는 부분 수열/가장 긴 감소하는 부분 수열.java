import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] num = new int[N];
		int[] memo = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		int max = 0;
		for (int i = 0; i < N; i++) {
			memo[i] = 1;
			for (int j = i; j >= 0; j--) {
				if (num[j] > num[i] && memo[j] >= memo[i]) {
					memo[i] = memo[j] + 1;
				}
			}
			max = Math.max(max, memo[i]);
		}
		System.out.println(max);
		
	}

}