import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int T, N, K, W, cost[], go[], memo[];
	static List<Integer>[] list;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			cost = new int[N + 1];
			go = new int[N + 1];
			memo = new int[N + 1];
			list = new ArrayList[N + 1];
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++) {
				list[i] = new ArrayList<>();
				cost[i] = Integer.parseInt(st.nextToken());
			}
			for (int i = 1; i <= K; i++) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				go[e]++;
				list[s].add(e);
			}
			W = Integer.parseInt(br.readLine());
			start();
			System.out.println(memo[W]);
		}
		
	}

	private static void start() {
		Queue<Integer> q = new ArrayDeque<>();
		for (int i = 1; i <= N; i++) {
			if (go[i] == 0) {
				q.offer(i);
				memo[i] = cost[i];
			}
		}
		while (!q.isEmpty()) {
			int cur = q.poll();
			for (Integer dest : list[cur]) {
				memo[dest] = Math.max(memo[dest], memo[cur] + cost[dest]);
				if (--go[dest] == 0) q.offer(dest);
			}
		}
	}

}
