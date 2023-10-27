import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M, x, y, K, map[][];
	static int dice[] = {0, 0, 0, 0, 0, 0}; //위, 북, 동, 서, 남, 아래

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) {
			switch (Integer.parseInt(st.nextToken())) {
			case 1: move1(); break;
			case 2: move2(); break;
			case 3: move3(); break;
			case 4: move4(); break;
			}
		}
		
	}

	private static void move1() {
		if (y + 1 >= M) return;
		if (map[x][++y] == 0) {
			map[x][y] = dice[2];
		} else {
			dice[2] = map[x][y];
			map[x][y] = 0;
		}
		int temp = dice[5];
		dice[5] = dice[2];
		dice[2] = dice[0];
		dice[0] = dice[3];
		dice[3] = temp;
		System.out.println(dice[0]);
	}

	private static void move2() {
		if (y - 1 < 0) return;
		if (map[x][--y] == 0) {
			map[x][y] = dice[3];
		} else {
			dice[3] = map[x][y];
			map[x][y] = 0;
		}
		int temp = dice[5];
		dice[5] = dice[3];
		dice[3] = dice[0];
		dice[0] = dice[2];
		dice[2] = temp;
		System.out.println(dice[0]);
	}

	private static void move3() {
		if (x - 1 < 0) return;
		if (map[--x][y] == 0) {
			map[x][y] = dice[4];
		} else {
			dice[4] = map[x][y];
			map[x][y] = 0;
		}
		int temp = dice[5];
		dice[5] = dice[4];
		dice[4] = dice[0];
		dice[0] = dice[1];
		dice[1] = temp;
		System.out.println(dice[0]);
	}

	private static void move4() {
		if (x + 1 >= N) return;
		if (map[++x][y] == 0) {
			map[x][y] = dice[1];
		} else {
			dice[1] = map[x][y];
			map[x][y] = 0;
		}
		int temp = dice[5];
		dice[5] = dice[1];
		dice[1] = dice[0];
		dice[0] = dice[4];
		dice[4] = temp;
		System.out.println(dice[0]);
	}

}
