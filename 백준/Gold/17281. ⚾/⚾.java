import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, bat[][], lineup[], score;
	static boolean[] isVisited;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		bat = new int[N][9];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				bat[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		lineup = new int[9];
		lineup[3] = 0;
		isVisited = new boolean[9];
		isVisited[0] = true;
		score = 0;
		perm(0);
		System.out.println(score);
		
	}

	private static void perm(int n) {
		if (n == 9) {
			scoring();
			return;
		}
		if (n == 3) {
			perm(n + 1);
			return;
		}
		for (int i = 0; i < 9; i++) {
			if (!isVisited[i]) {
				lineup[n] = i;
				isVisited[i] = true;
				perm(n + 1);
				isVisited[i] = false;
			}
		}
	}

	private static void scoring() {
		int cur_score = 0;
		int batter = 0;
		for (int i = 0; i < N; i++) {
			int out = 0;
			boolean[] runner = new boolean[3];
			while (out < 3) {
				if (bat[i][lineup[batter]] == 1) {
					if (runner[2]) {
						cur_score++;
						runner[2] = false;
					}
					for (int j = 1; j >= 0; j--) {
						if (runner[j]) {
							runner[j + 1] = true;
							runner[j] = false;
						}
					}
					runner[0] = true;
				} else if (bat[i][lineup[batter]] == 2) {
					for (int j = 1; j < 3; j++) {
						if (runner[j]) {
							cur_score++;
							runner[j] = false;
						}
					}
					if (runner[0]) {
						runner[2] = true;
						runner[0] = false;
					}
					runner[1] = true;
				} else if (bat[i][lineup[batter]] == 3) {
					for (int j = 0; j < 3; j++) {
						if (runner[j]) {
							cur_score++;
							runner[j] = false;
						}
					}
					runner[2] = true;
				} else if (bat[i][lineup[batter]] == 4) {
					for (int j = 0; j < 3; j++) {
						if (runner[j]) {
							cur_score++;
							runner[j] = false;
						}
					}
					cur_score++;
				} else if (bat[i][lineup[batter]] == 0) {
					out++;
				}
				batter = (batter + 1) % 9;
			}
		}
		if (cur_score > score) score = cur_score;
	}

}
