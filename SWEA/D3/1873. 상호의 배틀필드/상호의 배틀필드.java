import java.util.*;
public class Solution {
	static int[] dr = {-1, 1, 0, 0};  //상 하 좌 우
	static int[] dc = {0, 0, -1, 1};
	static int dir;
	static int row, col;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		for (int tc = 1; tc <= t; tc++) {
			int h = sc.nextInt();
			int w = sc.nextInt();
			String[][] map = new String[h][w];
			
			for (int i = 0; i < h; i++) {
				map[i] = sc.next().split("");
			}
			
			int n = sc.nextInt();
			String[] cmd = sc.next().split("");
			
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if(map[i][j].equals("^") || map[i][j].equals("<") || map[i][j].equals(">") || map[i][j].equals("v")) {
						if(map[i][j].equals("^")) dir = 0;
						else if(map[i][j].equals("<")) dir = 2;
						else if(map[i][j].equals(">"))  dir = 3;
						else if(map[i][j].equals("v")) dir = 1;
						row = i;
						col = j;
					}
				}
			}

			int nr, nc;
			for (int c = 0; c < cmd.length; c++) {
				switch (cmd[c]) {
					case "U":
						map[row][col] = "^";
						dir = 0;
						nr = row + dr[dir];
						nc = col + dc[dir];
						if(nr >= 0 && nr < h && nc >= 0 && nc < w && map[nr][nc].equals(".")) {
							map[row][col] = ".";
							map[nr][nc] = "^";
							row = nr;
							col = nc;
						}
						break;
					
					case "D":
						map[row][col] = "v";
						dir = 1;
						nr = row + dr[dir];
						nc = col + dc[dir];
						if(nr >= 0 && nr < h && nc >= 0 && nc < w && map[nr][nc].equals(".")) {
							map[row][col] = ".";
							map[nr][nc] = "v";
							row = nr;
							col = nc;
						}
						break;
						
					case "L":
						map[row][col] = "<";
						dir = 2;
						nr = row + dr[dir];
						nc = col + dc[dir];
						if(nr >= 0 && nr < h && nc >= 0 && nc < w && map[nr][nc].equals(".")) {
							map[row][col] = ".";
							map[nr][nc] = "<";
							row = nr;
							col = nc;
						}
						break;
						
					case "R":
						map[row][col] = ">";
						dir = 3;
						nr = row + dr[dir];
						nc = col + dc[dir];
						if(nr >= 0 && nr < h && nc >= 0 && nc < w && map[nr][nc].equals(".")) {
							map[row][col] = ".";
							map[nr][nc] = ">";
							row = nr;
							col = nc;
						}
						break;
					
					case "S":
						nr = row + dr[dir];
						nc = col + dc[dir];
						while(nr >= 0 && nr < h && nc >= 0 && nc < w) {
							if(map[nr][nc].equals("*")) {
								map[nr][nc] = ".";
								break;
							}
							else if(map[nr][nc].equals("#")) break;
							nr += dr[dir];
							nc += dc[dir];
						}
						break;
				}
			}
			System.out.print("#" + tc + " ");
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
		}
	}
}
