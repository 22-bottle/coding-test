import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	
	static int T, K, magnet[][] = new int[4][8], red[];

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			K = Integer.parseInt(br.readLine());
			StringTokenizer st = null;
			for (int i = 0; i < 4; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 8; j++) {
					magnet[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			red = new int[4];
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int mag = Integer.parseInt(st.nextToken()) - 1;
				int dir = Integer.parseInt(st.nextToken());
				if (mag != 3) rotateR(mag, dir);
				if (mag != 0) rotateL(mag, dir);
				rotate(mag, dir);
			}
			int score = 0;
			for (int i = 0; i < 4; i++) {
				if (magnet[i][red[i]] == 1) score += Math.pow(2, i);
			}
			System.out.printf("#%d %d\n", tc, score);
			
		}
	}

	private static void rotateR(int mag, int dir) {
		int me = (red[mag] + 2) % 8;
		int you = (red[mag + 1] + 6) % 8;
		if (magnet[mag][me] != magnet[mag + 1][you]) {
			if (mag < 2) rotateR(mag + 1, -dir);
			if (dir == 1) red[mag + 1] = (red[mag + 1] + 1) % 8;
			else red[mag + 1] = (red[mag + 1] + 7) % 8;
		}
	}
	
	private static void rotateL(int mag, int dir) {
		int me = (red[mag] + 6) % 8;
		int you = (red[mag - 1] + 2) % 8;
		if (magnet[mag][me] != magnet[mag - 1][you]) {
			if (mag > 1) rotateL(mag - 1, -dir);
			if (dir == 1) red[mag - 1] = (red[mag - 1] + 1) % 8;
			else red[mag - 1] = (red[mag - 1] + 7) % 8;
		}
	}
	
	private static void rotate(int mag, int dir) {
		if (dir == 1) red[mag] = (red[mag] + 7) % 8;
		else red[mag] = (red[mag] + 1) % 8;
	}

}
