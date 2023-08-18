import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int R, C, answer;
	static int[][] map;
	static boolean[] alphabet;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		for (int i = 0; i < R; i++) {
			char[] temp = br.readLine().toCharArray();
			for (int j = 0; j < C; j++) {
				map[i][j] = temp[j] - 'A';
			}
		}
		alphabet = new boolean[26];
		
		answer = 0;
		alphabet[map[0][0]] = true;
		move(0, 0, 1);
		System.out.println(answer);
	
	}
	
	private static void move(int r, int c, int cnt) {
		if (cnt > answer) answer = cnt;
		for (int d = 0; d < 4; d++) {
			if (r + dr[d] < 0 || r + dr[d] >= R || c + dc[d] < 0 || c + dc[d] >= C) continue;
			if (!alphabet[map[r + dr[d]][c + dc[d]]]) {
				alphabet[map[r + dr[d]][c + dc[d]]] = true;
				move(r + dr[d], c + dc[d], cnt + 1);
				alphabet[map[r + dr[d]][c + dc[d]]] = false;
			}
		}
	}

}