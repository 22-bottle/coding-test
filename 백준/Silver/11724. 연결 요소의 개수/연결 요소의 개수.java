import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M, answer;
	static boolean adj[][], visited[];

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		adj = new boolean[N + 1][N + 1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			adj[s][e] = true;
			adj[e][s] = true;			
		}
		visited = new boolean[N + 1];
		answer = 0;
		for (int i = 1; i <= N; i++) {
			if (!visited[i]) {
				bfs(i);
				answer++;
			}	
		}
		System.out.println(answer);
		
	}

	private static void bfs(int n) {
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(n);
		visited[n] = true;
		while (!q.isEmpty()) {
			int cur = q.poll();
			for (int i = 1; i <= N; i++) {
				if (!visited[i] && adj[cur][i]) {
					q.offer(i);
					visited[i] = true;
				}
			}
		}
	}

}
