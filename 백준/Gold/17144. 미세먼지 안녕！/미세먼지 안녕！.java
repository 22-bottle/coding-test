import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int R, C, T, map[][], temp[][], machine;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == -1) machine = i - 1;
			}
		}
		for (int t = 0; t < T; t++) {
			//diffusion
			temp = new int[R][C];
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (map[i][j] == 0 || map[i][j] == -1) continue;
					int dust = map[i][j] / 5, cnt = 0;
					for (int d = 0; d < 4; d++) {
						int nr = i + dr[d];
						int nc = j + dc[d];
						if (nr < 0 || nr >= R || nc < 0 || nc >= C || map[nr][nc] == -1) continue;
						temp[nr][nc] += dust;
						cnt++;
					}
					temp[i][j] -= dust * cnt;
				}
			}
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					map[i][j] += temp[i][j];
				}
			}
			//circulation
			for (int i = machine - 2; i >= 0; i--) {
				map[i + 1][0] = map[i][0];
			}
			for (int i = machine + 3; i < R; i++) {
				map[i - 1][0] = map[i][0];
			}
			for (int i = 1; i < C; i++) {
				map[0][i - 1] = map[0][i];
				map[R - 1][i - 1] = map[R - 1][i];
			}
			for (int i = 1; i <= machine; i++) {
				map[i - 1][C - 1] = map[i][C - 1];
			}
			for (int i = R - 2; i > machine; i--) {
				map[i + 1][C - 1] = map[i][C - 1];
			}
			for (int i = C - 2; i > 0; i--) {
				map[machine][i + 1] = map[machine][i];
				map[machine + 1][i + 1] = map[machine + 1][i];
			}
			map[machine][1] = 0;
			map[machine + 1][1] = 0;
		}
		int sum = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] != -1) sum += map[i][j];
			}
		}
		System.out.println(sum);
		
	}

}
