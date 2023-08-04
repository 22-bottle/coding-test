import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());
			int[] tastes = new int[N];
			int[] calories = new int[N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				tastes[i] = Integer.parseInt(st.nextToken());
				calories[i] = Integer.parseInt(st.nextToken());
			}
			
			int max_taste = 0;
			for (int i = 0; i < (1 << N); i++) {
				int cur_taste = 0;
				int cur_calorie = 0;
				for (int j = 0; j < N; j++) {
					if ((i & (1 << j)) != 0) {
						cur_taste += tastes[j];
						cur_calorie += calories[j];
						if (cur_calorie > L) break;
					}
				}
				if (cur_calorie <= L && cur_taste > max_taste) {
					max_taste = cur_taste;
				}
			}
			System.out.printf("#%d %d\n", tc, max_taste);
		}
	}
	
}
