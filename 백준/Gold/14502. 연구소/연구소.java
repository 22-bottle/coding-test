import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M, map[][], answer;
	static int[] sel = new int[3];
	static List<int[]> empty, virus;
	static boolean[][] visited;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		empty = new ArrayList<>();
		virus = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 0) empty.add(new int[] {i, j});
				else if (map[i][j] == 2) virus.add(new int[] {i, j});
			}
		}
		answer = 0;
		comb(0, 0);
		System.out.println(answer);
		
	}
	
	private static void comb(int idx, int start) {
		if (idx == 3) {
			bfs();
			return;
		}
		for (int i = start; i < empty.size(); i++) {
			sel[idx] = i;
			comb(idx + 1, i + 1);
		}
	}
	
	private static void bfs() {
		int[] cur = null;
		for (int i = 0; i < 3; i++) {
			cur = empty.get(sel[i]);
			map[cur[0]][cur[1]] = 1;
		}
		Queue<int[]> q = new ArrayDeque<>();
		for (int i = 0; i < virus.size(); i++) {
			q.offer(virus.get(i));
		}
		visited = new boolean[N][M];
		while (!q.isEmpty()) {
			cur = q.poll();
			for (int d = 0; d < 4; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
				if (map[nr][nc] == 0 && !visited[nr][nc]) {
					q.offer(new int[] {nr, nc});
					visited[nr][nc] = true;
				}
			}
		}
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0 && !visited[i][j]) cnt++;
			}
		}
		answer = Math.max(answer, cnt);
		for (int i = 0; i < 3; i++) {
			cur = empty.get(sel[i]);
			map[cur[0]][cur[1]] = 0;
		}
	}

}
