import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static List<Integer>[] friends;
	static boolean flag = false;
	static boolean[] isVisited;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		friends = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			friends[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			friends[a].add(b);
			friends[b].add(a);
		}
		
		for (int from = 0; from < N; from++) {
			isVisited = new boolean[N];
			isVisited[from] = true;
			go(1, from);
			if (flag) break;
		}
		if (flag) System.out.println(1);
		else System.out.println(0);
	}

	private static void go(int cnt, int from) {
		if (cnt == 5) {
			flag = true;
			return;
		}
        if (flag) return;
		for (int i = 0; i < friends[from].size(); i++) {
			int to = friends[from].get(i);
			if (!isVisited[to]) {
				isVisited[to] = true;
				go(cnt + 1, to);
				isVisited[to] = false;
			}
			if (flag) break;
		}
	}

}