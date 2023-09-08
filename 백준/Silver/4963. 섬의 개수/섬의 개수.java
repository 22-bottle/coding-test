import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int w, h, map[][];
	static int[] dr = {-1, 1, 0, 0, -1, -1, 1, 1};
	static int[] dc = {0, 0, -1, 1, -1, 1, -1, 1};

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			if (w == 0) break;
			map = new int[h][w];
			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int num = 2;
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (map[i][j] == 1) {
						bfs(i, j, num);
						num++;
					}
				}
			}
			System.out.println(num == 2 ? 0 : num - 2);
		}
	}
	
	private static void bfs(int r, int c, int n) {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {r, c});
		map[r][c] = n;
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			for (int d = 0; d < 8; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				if (nr < 0 || nr >= h || nc < 0 || nc >= w) continue;
				if (map[nr][nc] == 1) {
					map[nr][nc] = n;
					q.offer(new int[] {nr, nc});
				}
			}
		}
	}

}
