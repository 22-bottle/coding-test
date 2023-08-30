import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, voter[], adj[][], total, answer;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		voter = new int[N];
		total = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			voter[i] = Integer.parseInt(st.nextToken());
			total += voter[i];
		}
		adj = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			for (int j = 0; j < n; j++) {
				adj[i][Integer.parseInt(st.nextToken()) - 1] = 1;
			}
		}
		answer = Integer.MAX_VALUE;
		for (int c = 1; c < (1 << N) - 1; c++) {
			if (c == bfs(c) && c == bfs2(c)) {
				int cnt = 0;
				for (int v = 0; v < N; v++) {
					if ((c & (1 << v)) != 0) {
						cnt += voter[v];
					}
				}
				answer = Math.min(answer, Math.abs(total - 2 * cnt));
			}
		}
		System.out.println(answer != Integer.MAX_VALUE ? answer : -1);
		
	}
	
	private static int bfs(int c) { //1번 팀 확인
		int copy = 0;
		Queue<Integer> q = new ArrayDeque<>();
		int cur = 0;
		while ((c & (1 << cur)) == 0) {
			cur++;
		}
		q.offer(cur);
		boolean[] isVisited = new boolean[N];
		isVisited[cur] = true;
		copy = copy | (1 << cur);
		while (!q.isEmpty()) {
			cur = q.poll();
			for (int i = 0; i < N; i++) {
				if (!isVisited[i] && adj[cur][i] == 1 && (c & (1 << i)) != 0 && (copy & (1 << i)) == 0) {
					q.offer(i);
					isVisited[i] = true;
					copy = copy | (1 << i);
				}
			}
		}
		return copy;
	}
	
	private static int bfs2(int c) { //0번 팀 확인
		int copy = (1 << N) - 1;
		Queue<Integer> q = new ArrayDeque<>();
		int cur = 0;
		while ((c & (1 << cur)) != 0) {
			cur++;
		}
		q.offer(cur);
		boolean[] isVisited = new boolean[N];
		isVisited[cur] = true;
		copy = copy - (1 << cur);
		while (!q.isEmpty()) {
			cur = q.poll();
			for (int i = 0; i < N; i++) {
				if (!isVisited[i] && adj[cur][i] == 1 && (c & (1 << i)) == 0 && (copy & (1 << i)) != 0) {
					q.offer(i);
					isVisited[i] = true;
					copy = copy - (1 << i);
				}
			}
		}
		return copy;
	}

}
