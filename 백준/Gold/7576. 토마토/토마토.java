import java.util.*;
public class Main {
	static int m, n, zeroCnt, zero;
	static int[][] map;
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	static int day = 0;
	static boolean flag = true;
	static Queue<int[]> q = new LinkedList();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		m = sc.nextInt();
		n = sc.nextInt();
		map = new int[n][m];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(map[i][j] == 1) q.add(new int[] {i, j});
				else if(map[i][j] == 0) zeroCnt++;
			}
		}
		int zeroTemp = zeroCnt;

		bfs();
		if(zeroTemp - zero != 0) flag = false;
		if(flag) System.out.println(day);
		else System.out.println(-1);
	}
	
	private static void bfs() {
		if(zeroCnt == 0) return;
		while(!q.isEmpty()) {
			day++;
			int size = q.size();
			for (int cnt = 0; cnt < size; cnt++) {
				int[] temp = q.poll();
				for (int i = 0; i < 4; i++) {
					int nr = temp[0] +dr[i];
					int nc = temp[1] +dc[i];
					if(nr >= 0 && nr < n && nc >= 0 && nc < m && map[nr][nc] == 0) {
						map[nr][nc] = 1;
						zeroCnt--;
						zero++;
						if(zeroCnt == 0) return;
						
						q.add(new int[] {nr, nc});
					}
				}
			}
		}
	}
}
