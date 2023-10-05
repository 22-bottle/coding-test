import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M, into[];
	static List<Integer> students[];
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		students = new List[N + 1];
		for (int i = 1; i <= N; i++) {
			students[i] = new ArrayList<>();
		}
		into = new int[N + 1];
		visited = new boolean[N + 1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			students[s].add(e);
			into[e]++;
		}
		Stack<Integer> s = new Stack<>();
		for (int i = 1; i <= N; i++) {
			if (into[i] == 0) s.push(i);
		}
		StringBuilder sb = new StringBuilder();
		while (!s.isEmpty()) {
			int cur = s.pop();
			sb.append(cur + " ");
			for (int i = 0; i < students[cur].size(); i++) {
				int target = students[cur].get(i);
				if (!visited[target] && into[target] == 1) {
					s.add(target);
					visited[target] = true;
				} else into[target]--;
			}
		}
		System.out.println(sb);
		
	}

}
