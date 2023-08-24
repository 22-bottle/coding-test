import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
	
	static class Vertex implements Comparable<Vertex> {
		int no, weight;

		public Vertex(int no, int weight) {
			super();
			this.no = no;
			this.weight = weight;
		}

		@Override
		public int compareTo(Vertex o) {
			return Integer.compare(this.weight, o.weight);
		}
	}
	
	static int T, V, E;
	static long answer;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			answer = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			ArrayList<Vertex> adjList[] = new ArrayList[V + 1];
			for (int i = 1; i <= V; i++) {
				adjList[i] = new ArrayList();
			}
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				int w = Integer.parseInt(st.nextToken());
				adjList[s].add(new Vertex(e, w));
				adjList[e].add(new Vertex(s, w));
			}
			
			boolean[] isVisited = new boolean[V + 1];
			int[] minDist = new int[V + 1];
			Arrays.fill(minDist, Integer.MAX_VALUE);
			minDist[1] = 0;
			PriorityQueue<Vertex> pq = new PriorityQueue<>();
			pq.offer(new Vertex(1, 0));
			int cnt = 0;
			while (!pq.isEmpty()) {
				Vertex cur = pq.poll();
				if (isVisited[cur.no]) continue;
				answer += cur.weight;
				cnt++;
				if (cnt == V) break;
				isVisited[cur.no] = true;
				for (Vertex v: adjList[cur.no]) {
					if (!isVisited[v.no] && v.weight < minDist[v.no]) {
						minDist[v.no] = v.weight;
						pq.offer(new Vertex(v.no, v.weight));
					}
				}
			}
			System.out.printf("#%d %d\n", tc, answer);
		}
		
	}

}
