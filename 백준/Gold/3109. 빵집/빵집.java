import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int R, C, answer;
	static char[][] map;
	static boolean flag;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		for (int i = 0; i < R; i++) {
			char[] temp = br.readLine().toCharArray();
			for (int j = 0; j < C; j++) {
				map[i][j] = temp[j];
			}
		}
		
		answer = 0;
		for (int i = 0; i < R; i++) {
			flag = false;
			move(i, 0);
		}
		System.out.println(answer);
	}
	
	private static void move(int r, int c) {
		//basis
		if (c >= C - 1) {
			answer++;
			flag = true;
			return;
		}	
		//inductive
		if (r - 1 >= 0 && map[r - 1][c + 1] == '.') {
			map[r - 1][c + 1] = 'X';
			move(r - 1, c + 1);
		}
		if (!flag && map[r][c + 1] == '.') {
			map[r][c + 1] = 'X';
			move(r, c + 1);
		}
		if (!flag && r + 1 < R && map[r + 1][c + 1] == '.') {
			map[r + 1][c + 1] = 'X';
			move(r + 1, c + 1);
		}
	}

}