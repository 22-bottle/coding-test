import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int N, M, p[], a, b, c;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc).append(" ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			p = new int[N + 1];
			for (int i = 1; i <= N; i++) p[i] = i;
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				c = Integer.parseInt(st.nextToken());
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				if (c == 0) {
					union(a, b);
				} else {
					if (find(a) == find(b)) sb.append(1);
					else sb.append(0);
				}
			}
			System.out.println(sb);
		}
	}
	
	private static int find(int a) {
		if (p[a] == a) return a;
		return p[a] = find(p[a]);
	}
	
	private static boolean union(int a, int b) {
		int a_root = find(a);
		int b_root = find(b);
		if (a_root == b_root) return false;
		p[b_root] = a_root;
		return true;
	}

}
