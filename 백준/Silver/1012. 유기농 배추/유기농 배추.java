import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class Main {
	static int w, h, k, answer;
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	static int[][] map;
	static Queue<int[]> q = new LinkedList();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int tc = 1; tc <= t; tc++) {
			answer = 0;
			w = sc.nextInt();  // 가로 길이
			h = sc.nextInt();  // 세로 길이
			k = sc.nextInt();  // 배추 개수
			map = new int[h][w];
			for (int i = 0; i < k; i++) {
				int c = sc.nextInt();
				int r = sc.nextInt();
				map[r][c] = 1;
			}
			
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if(map[i][j] == 1) {
						q.add(new int[] {i, j});
						bfs();
					}
				}
			}
			System.out.println(answer);
		}
	}
	
	private static void bfs() {
		answer++;
		while(!q.isEmpty()) {
			int[] temp = q.poll();
//			map[temp[0]][temp[1]] = 0;
			for (int i = 0; i < 4; i++) {
				int nr = temp[0] + dr[i];
				int nc = temp[1] + dc[i];
				if(nr >= 0 && nr < h && nc >= 0 && nc < w && map[nr][nc] == 1) {
					q.add(new int[] {nr, nc});
					map[nr][nc] = 0;
				}
			}
		}
	}
}
