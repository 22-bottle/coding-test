import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, M, B, min_h = 256, max_h = 0;
	static int ans_t = Integer.MAX_VALUE, ans_h = 0, cur_t, cur_b;
	static int[][] map;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				min_h = Integer.min(min_h, map[i][j]);
				max_h = Integer.max(max_h, map[i][j]);
			}
		}

		for (int cur_h = min_h; cur_h <= max_h; cur_h++) {
			cur_t = 0;
			cur_b = B;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] > cur_h) {
						cur_b += map[i][j] - cur_h;
						cur_t += (map[i][j] - cur_h) * 2;
					} else if (map[i][j] < cur_h) {
						cur_b -= cur_h - map[i][j];
						cur_t += cur_h - map[i][j];
					}
				}
			}
			if (cur_b < 0) break;
			if (cur_t <= ans_t) {
				ans_t = cur_t;
				ans_h = cur_h;
			}
		}
		System.out.println(ans_t + " " + ans_h);
		
	}

}
