import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N, room[][], favorite[][], answer = 0;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		room = new int[N + 1][N + 1];
		favorite = new int[N * N][5];
		for (int i = 0; i < N * N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			favorite[i][0] = Integer.parseInt(st.nextToken()); 
			for (int j = 1; j <= 4; j++) {
				favorite[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < N * N; i++) {
			select(i);
		}
		calc();
		System.out.println(answer);
		
	}

	private static void select(int n) {
		int r = 0, c = 0, max_f = -1, max_e = -1, friend = -1, empty = -1;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (room[i][j] == 0) {
					friend = 0; empty = 0;
					for (int d = 0; d < 4; d++) {
						int nr = i + dr[d];
						int nc = j + dc[d];
						if (nr < 1 || nr > N || nc < 1 || nc > N) continue;
						if (room[nr][nc] == 0) empty++;
						else {
							for (int k = 1; k <= 4; k++) {
								if (room[nr][nc] == favorite[n][k]) {
									friend++;
									break;
								}
							}
						}
					}
				}
				if (friend > max_f || (friend == max_f && empty > max_e) || (max_f == -1 && max_e == -1)) {
					r = i;
					c = j;
					max_f = friend;
					max_e = empty;
				}
			}
		}
		room[r][c] = favorite[n][0];
	}

	private static void calc() {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				for (int k = 0; k < N * N; k++) {
					if (room[i][j] == favorite[k][0]) {
						int cnt = 0;
						for (int d = 0; d < 4; d++) {
							int nr = i + dr[d];
							int nc = j + dc[d];
							if (nr < 1 || nr > N || nc < 1 || nc > N) continue;
							for (int f = 1; f <= 4; f++) {
								if (room[nr][nc] == favorite[k][f]) {
									cnt++;
									break;
								}
							}
						}
						if (cnt > 0) answer += Math.pow(10, cnt - 1);
						break;
					}
				}
			}
		}
	}

}
