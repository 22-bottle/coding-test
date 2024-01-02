import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] input = new int[N];
		int[] mem = new int[N];
		int ans = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
			int cur = 0;
			for (int j = 0; j < i; j++) {
				if (input[i] > input[j])
					cur = Integer.max(cur, mem[j]);
			}
			mem[i] = cur + 1;
			ans = Integer.max(ans, mem[i]);
		}
		System.out.println(ans);
		
	}

}