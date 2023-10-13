import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int R, C, bieber[], time = 0;
	static char[][] map;
	static Queue<int[]> hogers = new ArrayDeque<>(), water = new ArrayDeque<>();
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		for (int i = 0; i < R; i++) {
			char[] temp = br.readLine().toCharArray();
			for (int j = 0; j < C; j++) {
				map[i][j] = temp[j];
				if (map[i][j] == 'S') hogers.offer(new int[] {i, j});
				else if (map[i][j] == 'D') bieber = new int[] {i, j};
				else if (map[i][j] == '*') water.offer(new int[] {i, j});
			}
		}
		while (true) {
			move();
			flood();
			if (hogers.size() == 0) {
				System.out.println("KAKTUS");
				break;
			}
			time++;
		}
		
	}

	private static void flood() {
		int size = water.size();
		for (int i = 0; i < size; i++) {
			int[] cur = water.poll();
			for (int d = 0; d < 4; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				if (nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
				if (map[nr][nc] == '.' || map[nr][nc] == 'S') {
					map[nr][nc] = '*';
					water.offer(new int[] {nr, nc});
				}
			}
		}
	}
	
	private static void move() {
		int size = hogers.size();
		for (int i = 0; i < size; i++) {
			int[] cur = hogers.poll();
			if (map[cur[0]][cur[1]] == '*') continue;
			for (int d = 0; d < 4; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				if (nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
				if (map[nr][nc] == '.') {
					map[nr][nc] = 'S';
					hogers.offer(new int[] {nr, nc});
				} else if (map[nr][nc] == 'D') {
					System.out.println(++time);
					System.exit(0);
				}
			}
		}
	}

}
