import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int T, N, map[][], cur_length;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int length = 0;
			int room_num = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					cur_length = 0;
					move(i, j);
					if (cur_length > length || (cur_length == length && map[i][j] < room_num)) {
						length = cur_length;
						room_num = map[i][j];
					}
				}
			}
			System.out.printf("#%d %d %d\n", tc, room_num, length);
		}
	}

	private static void move(int r, int c) {
		cur_length++;
		for (int i = 0; i < 4; i++) {
			if (r + dr[i] < 0 || r + dr[i] >= N || c + dc[i] < 0 || c + dc[i] >= N) continue;
			if (map[r + dr[i]][c + dc[i]] == map[r][c] + 1) {
				move(r + dr[i], c + dc[i]);
			}
		}
	}

}