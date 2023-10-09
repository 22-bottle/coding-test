import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static int N, sel[] = new int[3];
	static char[][] map;
	static List<int[]> blanks = new ArrayList<>();
	static List<int[]> teachers = new ArrayList<>();
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static boolean answer = false;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = st.nextToken().charAt(0);
				if (map[i][j] == 'X') blanks.add(new int[] {i, j});
				else if (map[i][j] == 'T') teachers.add(new int[] {i, j});
			}
		}
		comb(0, 0);
		System.out.println("NO");
		
	}

	private static void comb(int cnt, int idx) {
		if (cnt >= 3) {
			for (int i = 0; i < 3; i++) {
				int[] cur = blanks.get(sel[i]);
				map[cur[0]][cur[1]] = 'O';
			}
			answer = simulation();
			if (answer) {
				System.out.println("YES");
				System.exit(0);
			}
			for (int i = 0; i < 3; i++) {
				int[] cur = blanks.get(sel[i]);
				map[cur[0]][cur[1]] = 'X';
			}
			return;
		}
		for (int i = idx; i < blanks.size(); i++) {
			sel[cnt] = i;
			comb(cnt + 1, idx + 1);
		}
	}

	private static boolean simulation() {
		for (int i = 0; i < teachers.size(); i++) {
			for (int d = 0; d < 4; d++) {
				int nr = teachers.get(i)[0] + dr[d];
				int nc = teachers.get(i)[1] + dc[d];
				while (nr >= 0 && nr < N && nc >= 0 && nc < N) {
					if (map[nr][nc] == 'O') break;
					else if (map[nr][nc] == 'S') return false;
					nr += dr[d];
					nc += dc[d];
				}
			}
		}
		return true;
	}

}
