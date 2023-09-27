import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M, cheese[][], cnt = 0, time = 0;
	static boolean outside[][];
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		cheese = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				cheese[i][j] = Integer.parseInt(st.nextToken());
				if (cheese[i][j] == 1) cnt++;
			}
		}
		int last = 0;
		while (cnt > 0) {
			if (cnt > 0) last = cnt;
			bfs();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (cheese[i][j] == 1) {
						int cur_cnt = 0;
						for (int d = 0; d < 4; d++) {
							int nr = i + dr[d];
							int nc = j + dc[d];
							if (outside[nr][nc]) cur_cnt++;
						}
						if (cur_cnt >= 1) {
							cheese[i][j] = 0;
							cnt--;
						}
					}
				}
			}
			time++;
		}
		System.out.println(time);
		System.out.println(last);
		
	}

	private static void bfs() {
		outside = new boolean[N][M];
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {0, 0});
		outside[0][0] = true;
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			for (int i = 0; i < 4; i++) {
				int nr = cur[0] + dr[i];
				int nc = cur[1] + dc[i];
				if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
				if (!outside[nr][nc] && cheese[nr][nc] == 0) {
					q.offer(new int[] {nr, nc});
					outside[nr][nc] = true;
				}
			}
		}
	}

}
