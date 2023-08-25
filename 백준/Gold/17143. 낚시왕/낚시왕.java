import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static class Shark {
		int speed, direction, size;

		public Shark(int speed, int direction, int size) {
			super();
			this.speed = speed;
			this.direction = direction;
			this.size = size;
		}
	}

	static int R, C, M;
	static Shark[][] map;
	static int[] dr = {0, -1, 1, 0, 0};
	static int[] dc = {0, 0, 0, 1, -1};
	static boolean[][] visited;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new Shark[R + 1][C + 1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			map[r][c] = new Shark(s, d, z);
		}
		
		int shark_sum = 0;
		for (int king = 1; king <= C; king++) {
			for (int target = 1; target <= R; target++) {
				if (map[target][king] == null) continue;
				shark_sum += map[target][king].size;
				map[target][king] = null;
				break;
			}
			visited = new boolean[R + 1][C + 1];
			for (int i = 1; i <= R; i++) {
				for (int j = 1; j <= C; j++) {
					if (map[i][j] == null) continue;
					if (!visited[i][j])
						shark_move(i, j);
				}
			}
		}
		
		System.out.println(shark_sum);
		
	}

	private static void shark_move(int r, int c) {
		Shark me = map[r][c];
		map[r][c] = null;
		if (me.direction == 1 || me.direction == 2) {
			if (me.direction == 1) r -= me.speed;
			else r += me.speed;
			while (r <= 0 || r > R) {
				if (r <= 0) {
					r = 2 - r;
					me.direction = 2;
				}
				if (r > R) {
					r = (R << 1) - r;
					me.direction = 1;
				}
			}
		} else {
			if (me.direction == 3) c += me.speed;
			else c -= me.speed;
			while (c <= 0 || c > C) {
				if (c <= 0) {
					c = 2 - c;
					me.direction = 3;
				}
				if (c > C) {
					c = (C << 1) - c;
					me.direction = 4;
				}
			}
		}
		if (map[r][c] == null) {
			map[r][c] = me;
			visited[r][c] = true;
		} else {
			if (!visited[r][c]) shark_move(r, c);
			if (map[r][c] == null || me.size > map[r][c].size) {
				map[r][c] = me;
				visited[r][c] = true;
			}
		}
	}

}
