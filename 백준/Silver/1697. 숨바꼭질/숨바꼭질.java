import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N, K;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		System.out.println(bfs());

	}

	private static int bfs() {
		boolean[] isVisited = new boolean[100001];
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {N, 0});
		isVisited[N] = true;
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			if (cur[0] == K) {
				return cur[1];
			}
			if (cur[0] - 1 >= 0 && !isVisited[cur[0] - 1]) {
				q.offer(new int[] {cur[0] - 1, cur[1] + 1});
				isVisited[cur[0] - 1] = true;
			}
			if (cur[0] + 1 <= 100000 && !isVisited[cur[0] + 1]) {
				q.offer(new int[] {cur[0] + 1, cur[1] + 1});
				isVisited[cur[0] + 1] = true;
			}
			if (cur[0] * 2 <= 100000 && !isVisited[cur[0] * 2]) {
				q.offer(new int[] {cur[0] * 2, cur[1] + 1});
				isVisited[cur[0] * 2] = true;
			}
		}
		return -1;
	}

}