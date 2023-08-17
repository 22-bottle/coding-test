import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M, answer;
	static char board[][];
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static boolean flag;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new char[N][M];
		int[] red = new int[2];
		int[] blue = new int[2];
		for (int i = 0; i < N; i++) {
			char[] temp = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				board[i][j] = temp[j];
				if (board[i][j] == 'R') {
					red = new int[] {i, j};
				} else if (board[i][j] == 'B') {
					blue = new int[] {i, j};
				}
			}
		}
		answer = Integer.MAX_VALUE;
		move(red, blue, 0);
		if (answer == Integer.MAX_VALUE) answer = -1;
		System.out.println(answer);
	}
	
	private static void move(int[] red, int[] blue, int cnt) {
		if (cnt >= 10) {
			return;
		}
		for (int d = 0; d < 4; d++) {
			int[] temp_red = find(red, d);
			if (temp_red[0] + dr[d] == blue[0] && temp_red[1] + dc[d] == blue[1]) {
				int[] new_blue = find(blue, d);
				if (flag) continue;
				else {
					if (new_blue[0] != blue[0] || new_blue[1] != blue[1]) {
						board[blue[0]][blue[1]] = '.';
						board[new_blue[0]][new_blue[1]] = 'B';
						int[] new_red = find(red, d);
						if (flag) {
							board[blue[0]][blue[1]] = 'B';
							board[new_blue[0]][new_blue[1]] = '.';
							if (answer > cnt + 1) answer = cnt + 1;
							continue;
						} else {
							if (new_red[0] != red[0] || new_red[1] != red[1]) {
								board[red[0]][red[1]] = '.';
								board[new_red[0]][new_red[1]] = 'R';
								move(new_red, new_blue, cnt + 1);
								board[red[0]][red[1]] = 'R';
								board[new_red[0]][new_red[1]] = '.';
							} else {
								move(new_red, new_blue, cnt + 1);
							}
						}
						board[blue[0]][blue[1]] = 'B';
						board[new_blue[0]][new_blue[1]] = '.';
					} else {
						int[] new_red = find(red, d);
						if (flag) {
							if (answer > cnt + 1) answer = cnt + 1;
							continue;
						} else {
							if (new_red[0] != red[0] || new_red[1] != red[1]) {
								board[red[0]][red[1]] = '.';
								board[new_red[0]][new_red[1]] = 'R';
								move(new_red, new_blue, cnt + 1);
								board[red[0]][red[1]] = 'R';
								board[new_red[0]][new_red[1]] = '.';
							} else {
								continue;
							}
						}
					}
				}
			} else {
				int[] new_red = find(red, d);
				if (flag) {
					board[red[0]][red[1]] = '.';
					find(blue, d);
					board[red[0]][red[1]] = 'R';
					if (flag) {
						continue;
					} else {
						if (answer > cnt + 1) answer = cnt + 1;
						continue;
					}
				} else {
					if (new_red[0] != red[0] || new_red[1] != red[1]) {
						board[red[0]][red[1]] = '.';
						board[new_red[0]][new_red[1]] = 'R';
						int[] new_blue = find(blue, d);
						if (flag) {
							board[red[0]][red[1]] = 'R';
							board[new_red[0]][new_red[1]] = '.';
							continue;
						} else {
							if (new_blue[0] != blue[0] || new_blue[1] != blue[1]) {
								board[blue[0]][blue[1]] = '.';
								board[new_blue[0]][new_blue[1]] = 'B';
								move(new_red, new_blue, cnt + 1);
								board[blue[0]][blue[1]] = 'B';
								board[new_blue[0]][new_blue[1]] = '.';
							} else {
								move(new_red, new_blue, cnt + 1);
							}
						}
						board[red[0]][red[1]] = 'R';
						board[new_red[0]][new_red[1]] = '.';
					} else {
						int[] new_blue = find(blue, d);
						if (flag) {
							continue;
						} else {
							if (new_blue[0] != blue[0] || new_blue[1] != blue[1]) {
								board[blue[0]][blue[1]] = '.';
								board[new_blue[0]][new_blue[1]] = 'B';
								move(new_red, new_blue, cnt + 1);
								board[blue[0]][blue[1]] = 'B';
								board[new_blue[0]][new_blue[1]] = '.';
							} else {
								continue;
							}
						}
					}
				}
			}
		}
	}
	
	private static int[] find(int[] l, int d) {
		flag = false;
		int w = 1;
		while (board[l[0] + dr[d] * w][l[1] + dc[d] * w] == '.') {
			w++;
		}
		if (board[l[0] + dr[d] * w][l[1] + dc[d] * w] == 'O') flag = true;
		return new int[] {l[0] + dr[d] * (w - 1), l[1] + dc[d] * (w - 1)};
	}

}