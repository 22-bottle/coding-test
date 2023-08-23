import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	static int N, S, latest[];
	static boolean[][] contact;
	static boolean[] isVisited;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 1; tc <= 10; tc++) {
			contact = new boolean[100][100];
			isVisited = new boolean[100];
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			S = Integer.parseInt(st.nextToken()) - 1;
			latest = new int[] {0, 0};
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < (N >> 1); i++) {
				int from = Integer.parseInt(st.nextToken()) - 1;
				int to = Integer.parseInt(st.nextToken()) - 1;
				contact[from][to] = true;
			}
			call();
			System.out.printf("#%d %d\n", tc, latest[0] + 1);
		}
		
	}

	private static void call() {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {S, 0});
		isVisited[S] = true;
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			if (cur[1] > latest[1] || (cur[1] == latest[1] && cur[0] > latest[0])) {
				latest[0] = cur[0];
				latest[1] = cur[1];
			}
			for (int i = 0; i < 100; i++) {
				if (!isVisited[i] && contact[cur[0]][i]) {
					q.offer(new int[] {i, cur[1] + 1});
					isVisited[i] = true;
				}
			}
		}
	}

}
