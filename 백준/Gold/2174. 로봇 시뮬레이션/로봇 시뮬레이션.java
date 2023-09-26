import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static int A, B, N, M;
	static int[][] map;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static List<int[]> robots = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		map = new int[B][A];
		for (int i = 0; i < B; i++) {
			Arrays.fill(map[i], Integer.MAX_VALUE);
		}
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int c = Integer.parseInt(st.nextToken()) - 1;
			int r = B - Integer.parseInt(st.nextToken());
			char d = st.nextToken().charAt(0);
			if (d == 'N') map[r][c] = 0;
			else if (d == 'E') map[r][c] = 1;
			else if (d == 'S') map[r][c] = 2;
			else if (d == 'W') map[r][c] = 3;
			robots.add(new int[] {r, c});
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int ro = Integer.parseInt(st.nextToken()) - 1;
			char co = st.nextToken().charAt(0);
			int n = Integer.parseInt(st.nextToken());
			int[] cur_ro = robots.get(ro);
			if (co == 'L') {
				n = n % 4;
				map[cur_ro[0]][cur_ro[1]] = (map[cur_ro[0]][cur_ro[1]] + (4 - n)) % 4;
			} else if (co == 'R') {
				n = n % 4;
				map[cur_ro[0]][cur_ro[1]] = (map[cur_ro[0]][cur_ro[1]] + n) % 4;
			} else if (co == 'F') {
				int nr = cur_ro[0];
				int nc = cur_ro[1];
				int dir = map[nr][nc];
				for (int j = 0; j < n; j++) {
					nr += dr[dir];
					nc += dc[dir];
					if (nr < 0 || nr >= B || nc < 0 || nc >= A) {
						System.out.println("Robot " + (ro + 1) + " crashes into the wall");
						System.exit(0);
					}
					if (map[nr][nc] != Integer.MAX_VALUE) {
						for (int k = 0; k < robots.size(); k++) {
							if (robots.get(k)[0] == nr && robots.get(k)[1] == nc) {
								System.out.println("Robot " + (ro + 1) + " crashes into robot " + (k + 1));
								System.exit(0);
							}
						}
					}
				}
				map[cur_ro[0]][cur_ro[1]] = Integer.MAX_VALUE;
				map[nr][nc] = dir;
				cur_ro[0] = nr;
				cur_ro[1] = nc;
			}
		}
		System.out.println("OK");
	}

}
