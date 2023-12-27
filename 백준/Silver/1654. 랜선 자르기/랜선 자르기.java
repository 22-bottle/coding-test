import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int K, N;
	static long min_l = 0, max_l = 0, mid_l;
	static int[] lines;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		K = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		lines = new int[K];
		for (int i = 0; i < K; i++) {
			lines[i] = Integer.parseInt(br.readLine());
			if (lines[i] > max_l) max_l = lines[i];
		}
		max_l++;
		while (min_l < max_l) {
			mid_l = (min_l + max_l) / 2;
			long count = 0;
			for (int i = 0; i < K; i++) {
				count += lines[i] / mid_l;
			}
			if (count < N) {
				max_l = mid_l;
			} else {
				min_l = mid_l + 1;
			}
		}
		System.out.println(min_l - 1);
		
	}

}
