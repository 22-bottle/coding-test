import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static class Route {
		int dest;
		int cost;
		Route next;
		
		public Route(int dest, int cost, Route next) {
			super();
			this.dest = dest;
			this.cost = cost;
			this.next = next;
		}
	}
	
	static int N, M, S, D, cost[];
	static Route[] routes;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		routes = new Route[N + 1];
		cost = new int[N + 1];
		visited = new boolean[N + 1];
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			routes[s] = new Route(d, c, routes[s]);
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		S = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		dijkstra();
		System.out.println(cost[D]);
		
	}

	private static void dijkstra() {
		Arrays.fill(cost, Integer.MAX_VALUE);
		cost[S] = 0;
		for (int i = 1; i <= N; i++) {
			int min = Integer.MAX_VALUE;
			int idx = -1;
			for (int j = 1; j <= N; j++) {
				if (!visited[j] && cost[j] < min) {
					min = cost[j];
					idx = j;
				}
			}
			if (idx == -1 || idx == D) break;
			visited[idx] = true;
			for (Route temp = routes[idx]; temp != null; temp = temp.next) {
				if (!visited[temp.dest] && cost[temp.dest] > min + temp.cost) {
					cost[temp.dest] = min + temp.cost;
				}
			}
		}
	}

}
