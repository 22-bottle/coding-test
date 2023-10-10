import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M, map[][], island = 2, mat[][];
	static List<int[]> lands = new ArrayList<>();
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) lands.add(new int[] {i, j});
			}
		}
		for (int i = 0; i < lands.size(); i++) {
			int[] cur_land = lands.get(i);
			if (map[cur_land[0]][cur_land[1]] == 1) {
				bfs(cur_land);
			}
		}
		mat = new int[island][island];
		for (int i = 0; i < island; i++) {
			Arrays.fill(mat[i], Integer.MAX_VALUE);
		}
		for (int i = 0; i < lands.size(); i++) {
			int[] cur_land = lands.get(i);
			start(cur_land);
		}
		System.out.println(prim());
		
	}		

	private static void bfs(int[] land) {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {land[0], land[1]});
		map[land[0]][land[1]] = island;
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			for (int d = 0; d < 4; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
				if (map[nr][nc] == 1) {
					q.offer(new int[] {nr, nc});
					map[nr][nc] = island;
				}
			}
		}
		island++;
	}
	
	private static void start(int[] cur_land) {
		int cur_island = map[cur_land[0]][cur_land[1]];
		for (int d = 0; d < 4; d++) {
			int length = 0;
			int nr = cur_land[0] + dr[d];
			int nc = cur_land[1] + dc[d];
			while (nr >= 0 && nr < N && nc >= 0 && nc < M) {
				if (map[nr][nc] == cur_island) break;
				else if (map[nr][nc] == 0) {
					length++;
					nr += dr[d];
					nc += dc[d];
				} else {
					if (length >= 2) {
						int new_island = map[nr][nc];
						mat[cur_island][new_island] = Math.min(mat[cur_island][new_island], length);
					}
					break;
				}
			}
		}
	}
	
	private static int prim() {
		int[] min = new int[island];
		boolean[] visited = new boolean[island];
		int result = 0, cnt = 2;
		for (int i = 3; i < island; i++) {
			min[i] = Integer.MAX_VALUE;
		}
		while (true) {
			int min_idx = 0, min_value = Integer.MAX_VALUE;
			for (int i = 2; i < island; i++) {
				if (!visited[i]) {
					if (min[i] < min_value) {
						min_idx = i;
						min_value = min[i];
					}
				}
			}
			if (min_value == Integer.MAX_VALUE) return -1;
			visited[min_idx] = true;
			result += min[min_idx];
			if (++cnt == island) break;
			for (int i = 2; i < island; i++) {
				if (!visited[i] && mat[min_idx][i] < min[i]) {
					min[i] = mat[min_idx][i];
				}
			}
		}
		return result;
	}

}
