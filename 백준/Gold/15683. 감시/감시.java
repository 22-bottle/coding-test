import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int N, M, map[][], ds[], answer, wall;
	static List<int[]> cams;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		wall = 0;
		cams = new ArrayList<>();
		answer = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] != 0) {
					if (map[i][j] == 6) wall++;
					else cams.add(new int[] {i, j, map[i][j]});
				}
			}
		}
		ds = new int[cams.size()];
		set_up(0);
		System.out.println(answer);
	}

	private static void set_up(int n) {
		if (n == cams.size()) {
			int cur = calc();
			cur = (N * M) - cur - wall;
			if (cur < answer) {
				answer = cur;
			}
			return;
		}
		if (cams.get(n)[2] == 5) {
			ds[n] = 0;
			set_up(n + 1);
		} else if (cams.get(n)[2] == 2) {
			for (int i = 0; i < 2; i++) {
				ds[n] = i;
				set_up(n + 1);
			}
		} else {
			for (int i = 0; i < 4; i++) {
				ds[n] = i;
				set_up(n + 1);
			}
		}
	}

	private static int calc() {
		boolean[][] isVisited = new boolean[N][M];
		int cnt = 0;
		for (int i = 0; i < cams.size(); i++) {
			int[] cam = cams.get(i);
			int r = cam[0];
			int c = cam[1];
			int w = 1;
			if (!isVisited[r][c]) {
				isVisited[r][c] = true;
				cnt++;				
			}
			if (cam[2] == 1) {
				while (r + dr[ds[i]] * w >= 0 && r + dr[ds[i]] * w < N && c + dc[ds[i]] * w >= 0 && c + dc[ds[i]] * w < M && map[r + dr[ds[i]] * w][c + dc[ds[i]] * w] != 6) {
					if (!isVisited[r + dr[ds[i]] * w][c + dc[ds[i]] * w]) {
						cnt++;
						isVisited[r + dr[ds[i]] * w][c + dc[ds[i]] * w] = true;
					}
					w++;
				}
			} else if (cam[2] == 2) {
				while (r + dr[ds[i]] * w >= 0 && r + dr[ds[i]] * w < N && c + dc[ds[i]] * w >= 0 && c + dc[ds[i]] * w < M && map[r + dr[ds[i]] * w][c + dc[ds[i]] * w] != 6) {
					if (!isVisited[r + dr[ds[i]] * w][c + dc[ds[i]] * w]) {
						cnt++;
						isVisited[r + dr[ds[i]] * w][c + dc[ds[i]] * w] = true;
					}
					w++;
				}
				w = 1;
				while (r - dr[ds[i]] * w >= 0 && r - dr[ds[i]] * w < N && c - dc[ds[i]] * w >= 0 && c - dc[ds[i]] * w < M && map[r - dr[ds[i]] * w][c - dc[ds[i]] * w] != 6) {
					if (!isVisited[r - dr[ds[i]] * w][c - dc[ds[i]] * w]) {
						cnt++;
						isVisited[r - dr[ds[i]] * w][c - dc[ds[i]] * w] = true;
					}
					w++;
				}
			} else if (cam[2] == 3) {
				while (r + dr[ds[i]] * w >= 0 && r + dr[ds[i]] * w < N && c + dc[ds[i]] * w >= 0 && c + dc[ds[i]] * w < M && map[r + dr[ds[i]] * w][c + dc[ds[i]] * w] != 6) {
					if (!isVisited[r + dr[ds[i]] * w][c + dc[ds[i]] * w]) {
						cnt++;
						isVisited[r + dr[ds[i]] * w][c + dc[ds[i]] * w] = true;
					}
					w++;
				}
				w = 1;
				int d = (ds[i] + 1) % 4;
				while (r + dr[d] * w >= 0 && r + dr[d] * w < N && c + dc[d] * w >= 0 && c + dc[d] * w < M && map[r + dr[d] * w][c + dc[d] * w] != 6) {
					if (!isVisited[r + dr[d] * w][c + dc[d] * w]) {
						cnt++;
						isVisited[r + dr[d] * w][c + dc[d] * w] = true;
					}
					w++;
				}
			} else if (cam[2] == 4) {
				while (r + dr[ds[i]] * w >= 0 && r + dr[ds[i]] * w < N && c + dc[ds[i]] * w >= 0 && c + dc[ds[i]] * w < M && map[r + dr[ds[i]] * w][c + dc[ds[i]] * w] != 6) {
					if (!isVisited[r + dr[ds[i]] * w][c + dc[ds[i]] * w]) {
						cnt++;
						isVisited[r + dr[ds[i]] * w][c + dc[ds[i]] * w] = true;
					}
					w++;
				}
				w = 1;
				int d = (ds[i] + 1) % 4;
				while (r + dr[d] * w >= 0 && r + dr[d] * w < N && c + dc[d] * w >= 0 && c + dc[d] * w < M && map[r + dr[d] * w][c + dc[d] * w] != 6) {
					if (!isVisited[r + dr[d] * w][c + dc[d] * w]) {
						cnt++;
						isVisited[r + dr[d] * w][c + dc[d] * w] = true;
					}
					w++;
				}
				w = 1;
				d = (ds[i] + 2) % 4;
				while (r + dr[d] * w >= 0 && r + dr[d] * w < N && c + dc[d] * w >= 0 && c + dc[d] * w < M && map[r + dr[d] * w][c + dc[d] * w] != 6) {
					if (!isVisited[r + dr[d] * w][c + dc[d] * w]) {
						cnt++;
						isVisited[r + dr[d] * w][c + dc[d] * w] = true;
					}
					w++;
				}
			} else if (cam[2] == 5) {
				for (int j = 0; j < 4; j++) {
					w = 1;
					while (r + dr[j] * w >= 0 && r + dr[j] * w < N && c + dc[j] * w >= 0 && c + dc[j] * w < M && map[r + dr[j] * w][c + dc[j] * w] != 6) {
						if (!isVisited[r + dr[j] * w][c + dc[j] * w]) {
							cnt++;
							isVisited[r + dr[j] * w][c + dc[j] * w] = true;
						}
						w++;
					}
				}
			}
		}
		return cnt;
	}

}
