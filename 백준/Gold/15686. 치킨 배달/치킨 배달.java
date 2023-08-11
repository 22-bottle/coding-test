import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int N, M, map[][], answer = Integer.MAX_VALUE;
	static List<Node> chickens = new LinkedList<>();
	static List<Node> homes = new LinkedList<>();
	static int[] sel;
	
	static class Node {
		int r;
		int c;
		
		public Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		sel = new int[M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				int temp = Integer.parseInt(st.nextToken());
				map[i][j] = temp;
				if (temp == 1) homes.add(new Node(i, j));
				else if (temp == 2) chickens.add(new Node(i, j));
			}
		}
		comb(0, 0);
		System.out.println(answer);
	}
	
	private static void comb(int cnt, int start) {
		if (cnt == M) {
			if (calc_distance() < answer) {
				answer = calc_distance();
			}
			return;
		}
		for (int i = start; i < chickens.size(); i++) {
			sel[cnt] = i;
			comb(cnt + 1, i + 1);
		}
	}
	
	private static int calc_distance() {
		int sum = 0;
		for (int i = 0; i < homes.size(); i++) {
			int min = Integer.MAX_VALUE;
			Node cur_home = homes.get(i);
			for (int j = 0; j < sel.length; j++) {
				Node cur_chicken = chickens.get(sel[j]);
				if (Math.abs(cur_home.r - cur_chicken.r) + Math.abs(cur_home.c - cur_chicken.c) < min) {
					min = Math.abs(cur_home.r - cur_chicken.r) + Math.abs(cur_home.c - cur_chicken.c);
				}
			}
			sum += min;
		}
		return sum;
	}

}