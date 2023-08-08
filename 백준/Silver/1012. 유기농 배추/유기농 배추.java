import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int T, M, N, K;
	static boolean[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new boolean[M][N];
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = true;
			}
			
			int count = 0;
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j]) {
						count++;
						bfs(i, j);
					}
				}
			}
			sb.append(count + "\n");			
		}
		System.out.println(sb);
	}
	
	private static void bfs(int x, int y) {
		Queue<int[]> q = new ArrayDeque<>();
		int[] dr = {-1, 0, 1, 0};
		int[] dc = {0, 1, 0, -1};
		
		q.offer(new int[] {x, y});
		map[x][y] = false;
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			for (int i = 0; i < 4; i++) {
				int cur_r = cur[0] + dr[i];
				int cur_c = cur[1] + dc[i];
				if (cur_r < 0 || cur_r >= M || cur_c < 0 || cur_c >= N) {
					continue;
				}
				if (map[cur_r][cur_c]) {
					q.offer(new int[] {cur_r, cur_c});
					map[cur_r][cur_c] = false;
				}
			}
		}
	}

}