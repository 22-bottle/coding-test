import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int T, N, parent[], p, c, n1, n2;
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception {
		
		StringTokenizer st = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			parent = new int[N + 1];
			Arrays.fill(parent, -1);
			visited = new boolean[N + 1];
			for (int i = 0; i < N - 1; i++) {
				st = new StringTokenizer(br.readLine());
				p = Integer.parseInt(st.nextToken());
				c = Integer.parseInt(st.nextToken());
				parent[c] = p;
			}
			st = new StringTokenizer(br.readLine());
			n1 = Integer.parseInt(st.nextToken());
			n2 = Integer.parseInt(st.nextToken());
			go(n1);
			System.out.println(go(n2));
		}
		
	}

	private static int go(int n) {
		int cur = n;
		while (!visited[cur]) {
			visited[cur] = true;
			if (parent[cur] == -1) break;
			cur = parent[cur];
		}
		return cur;
	}

}
