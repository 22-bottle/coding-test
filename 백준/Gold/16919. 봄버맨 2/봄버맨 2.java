import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int R, C, N, bomb;
	static int[][] map;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		for (int i = 0; i < R; i++) {
			char[] temp = br.readLine().toCharArray();
			for (int j = 0; j < C; j++) {
				if (temp[j] == 'O') map[i][j] = 1;
			}
		}
		if (N == 1) {
			print();
			return;
		}
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == 0) map[i][j] = 2;
			}
		}
		if (N == 2) {
			print();
			return;
		}
		
		bomb = 1;
		N = (N - 2) % 4;
		for (int s = 0; s < N; s++) {
			if (s % 2 == 1) {
				plant(bomb);
				bomb = (bomb == 1) ? 2 : 1;
			} else {
				burst(bomb);
			}
		}
		print();
	}
	
	private static void plant(int bomb) {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == 0) map[i][j] = bomb;
			}
		}
	}
	
	private static void burst(int bomb) {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == bomb) {
					map[i][j] = 0;
					for (int d = 0; d < 4; d++) {
						if (i + dr[d] < 0 || i + dr[d] >= R || j + dc[d] < 0 || j + dc[d] >= C) continue;
						if (map[i + dr[d]][j + dc[d]] != bomb) map[i + dr[d]][j + dc[d]] = 0;
					}
				}
			}
		}
	}
	
	private static void print() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == 0) sb.append('.');
				else sb.append('O');
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}

}