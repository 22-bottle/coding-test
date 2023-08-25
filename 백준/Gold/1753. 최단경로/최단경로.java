import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static int V, E, K, dist[];
	static List<int[]>[] adjList;
	static boolean[] visited;

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		adjList = new ArrayList[V + 1];
		for (int i = 1; i < V + 1; i++) {
			adjList[i] = new ArrayList<>();
		}
		dist = new int[V + 1];
		visited = new boolean[V + 1];
		E = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(br.readLine());
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			adjList[u].add(new int[] {v, w});
		}
		
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[K] = 0;
		for (int i = 0; i < V; i++) {
			int min_dist = Integer.MAX_VALUE;
			int min_idx = -1;
			for (int j = 1; j <= V; j++) {
				if (!visited[j] && dist[j] < min_dist) {
					min_dist = dist[j];
					min_idx = j;
				}
			}
			if (min_idx == -1) break;
			visited[min_idx] = true;
			for (int[] vertex : adjList[min_idx]) {
				if (!visited[vertex[0]] && dist[vertex[0]] > min_dist + vertex[1]) {
					dist[vertex[0]] = min_dist + vertex[1];
				}
			}
		}
		
		for (int i = 1; i <= V; i++) {
			System.out.println(dist[i] != Integer.MAX_VALUE ? dist[i] : "INF");
		}
		
	}

}
