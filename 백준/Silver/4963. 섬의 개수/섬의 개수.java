import java.util.*;
public class Main {
	static int[] dr = {0, 1, 1, 1, -1, 0, -1, -1};
	static int[] dc = {1, 1, 0, -1, -1, -1, 1, 0};
	static int[][] map;
	static int w, h;
	static boolean flag = true;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			w = sc.nextInt();
			h = sc.nextInt();
			int answer = 0;
			
			if(w == 0 && h == 0) break;
			
			map = new int[h][w];
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					dfs(i, j);
					if(flag) answer ++;
				}
			}
			System.out.println(answer);
		}
	}
	
	private static void dfs(int r, int c) {
		
		if(map[r][c] == 0) {
			flag = false;
			return;
		}
		else {
			map[r][c] = 0;
			flag = true;
		}
		
		for (int i = 0; i < 8; i++) {
			int ny = r + dr[i];
			int nc = c + dc[i];
			if(ny >= 0 && ny < h && nc >= 0 && nc < w && map[ny][nc] == 1) {
				dfs(ny, nc);
			}
		}
	}

}
