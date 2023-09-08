import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M, map[][], cnt, sel[], answer;
	static List<int[]> viruses;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		viruses = new ArrayList<>();
		cnt = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					viruses.add(new int[] {i, j, 0});
				} else if (map[i][j] == 0) cnt++;
			}
		}
		sel = new int[M];
		answer = Integer.MAX_VALUE;
		comb(0, 0);
		System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
		
	}
	
	private static void comb(int n, int idx) {
		if (n == M) {
			answer = Math.min(answer, start());
			return;
		}
		for (int i = idx; i < viruses.size(); i++) {
			sel[n] = i;
			comb(n + 1, i + 1);
		}
	}
	
	private static int start() {
		Queue<int[]> q = new ArrayDeque<>();
		boolean[][] visited = new boolean[N][N];
		int[] cur = null;
		for (int i = 0; i < M; i++) {
			cur = viruses.get(sel[i]);
			q.add(cur);
			visited[cur[0]][cur[1]] = true;
		}
		int c = cnt;
		while (!q.isEmpty()) {
			cur = q.poll();
			if (c == 0) return cur[2];
			for (int d = 0; d < 4; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
				if (!visited[nr][nc] && map[nr][nc] != 1) {
					if (map[nr][nc] == 0) {
						q.add(new int[] {nr, nc, cur[2] + 1});
						c--;
						if (c == 0) return cur[2] + 1;
					}
					else if (map[nr][nc] == 2) q.add(new int[] {nr, nc, cur[2] + 1});
					visited[nr][nc] = true;
				}
			}
		}
		return Integer.MAX_VALUE;
	}

}