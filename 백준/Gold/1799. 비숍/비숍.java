import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int N, board[][], answer1 = 0, answer2 = 0;
	static boolean[] visited1, visited2;
	static List<int[]> empty1, empty2;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		board = new int[N][N];
		empty1 = new LinkedList<>();
		empty2 = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (board[i][j] == 1 && (i + j) % 2 == 0) {
					empty1.add(new int[] {i, j});
				} else if (board[i][j] == 1 && (i + j) % 2 == 1) {
					empty2.add(new int[] {i, j});
				}
			}
		}
		visited1 = new boolean[N * 2];
		visited2 = new boolean[N * 2];
		backtracking1(0, 0);
		backtracking2(0, 0);
		System.out.println(answer1 + answer2);
		
	}

	private static void backtracking1(int idx, int cnt) {
		if (idx == empty1.size()) {
			answer1 = Math.max(answer1, cnt);
			return;
		}
		if (empty1.size() - idx + cnt <= answer1) {
			return;
		}
		int[] cur = empty1.get(idx);
		if (!visited1[cur[0] + cur[1]] && !visited2[cur[0] - cur[1] + N]) {
			visited1[cur[0] + cur[1]] = true;
			visited2[cur[0] - cur[1] + N] = true;
			backtracking1(idx + 1, cnt + 1);
			visited1[cur[0] + cur[1]] = false;
			visited2[cur[0] - cur[1] + N] = false;
		}
		backtracking1(idx + 1, cnt);
	}
	
	private static void backtracking2(int idx, int cnt) {
		if (idx == empty2.size()) {
			answer2 = Math.max(answer2, cnt);
			return;
		}
		if (empty2.size() - idx + cnt <= answer2) {
			return;
		}
		int[] cur = empty2.get(idx);
		if (!visited1[cur[0] + cur[1]] && !visited2[cur[0] - cur[1] + N]) {
			visited1[cur[0] + cur[1]] = true;
			visited2[cur[0] - cur[1] + N] = true;
			backtracking2(idx + 1, cnt + 1);
			visited1[cur[0] + cur[1]] = false;
			visited2[cur[0] - cur[1] + N] = false;
		}
		backtracking2(idx + 1, cnt);
	}

}
