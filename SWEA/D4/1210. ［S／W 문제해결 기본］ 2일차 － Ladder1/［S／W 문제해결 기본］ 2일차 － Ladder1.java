import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static int[][] map = new int[100][100];
	static int x;
	static int y = 99;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 10;
		for (int test_case = 1; test_case <= T; test_case++) {
			y = 99;
			String t = br.readLine();
			for (int i = 0; i < 99; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < 100; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < 100; i++) {
				map[99][i] = Integer.parseInt(st.nextToken());
				if (map[99][i] == 2) {
					x = i;
				}
			}
			move();
			System.out.printf("#%d %d\n", test_case, x);
		}
	}
	
	public static void move() {
		//inductive
		while (y > 0 && (x - 1 < 0 || map[y][x - 1] == 0) && (x + 1 > 99 || map[y][x + 1] == 0)) {
			y--;
		}
		if (y <= 0) { //basis
			return;
		} else {
			if (x - 1 >= 0 && map[y][x - 1] == 1) {
				while (x - 1 >= 0 && map[y][x - 1] == 1) {
					x--;
				}
			} else {
				while (x + 1 < 100 && map[y][x + 1] == 1) {
					x++;
				}
			}
			y--;
			move();
		}
	}

}