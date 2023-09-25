import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M, D, sel[] = new int[3], answer = 0;
	static Integer[] target = new Integer[3];
	static ArrayList<int[]> enemies = new ArrayList<>(), copy;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				if (Integer.parseInt(st.nextToken()) == 1) enemies.add(new int[] {i, j});
			}
		}
		comb(0, 0);
		System.out.println(answer);
		
	}
	
	public static void comb(int idx, int start) {
		if (idx >= 3) {
			answer = Math.max(answer, simul());
			return;
		}
		for (int i = start; i < M; i++) {
			sel[idx] = i;
			comb(idx + 1, i + 1);
		}
	}

	private static int simul() {
		int cnt = 0;
		copy = new ArrayList<>();
		for (int i = 0; i < enemies.size(); i++) {
			int[] cur = enemies.get(i);
			copy.add(new int[] { cur[0], cur[1] });
		}
		while (copy.size() > 0) {
			Arrays.fill(target, Integer.MAX_VALUE);
			for (int a = 0; a < 3; a++) {
				int min_d = Integer.MAX_VALUE;
				for (int e = 0; e < copy.size(); e++) {
					int d = Math.abs(copy.get(e)[0] - N) + Math.abs(copy.get(e)[1] - sel[a]);
					if (d > D) continue;
					if (d < min_d) {
						target[a] = e;
						min_d = d;
					} else if (d == min_d && copy.get(e)[1] < copy.get(target[a])[1]) {
						target[a] = e;
					}
				}
			}
			Arrays.sort(target, (o1, o2) -> { return o2 - o1; });
			for (int i = 0; i < 3; i++) {
				if (target[i] == Integer.MAX_VALUE) continue;
				if (i == 2) {
					copy.remove(target[2].intValue());
					cnt++;
					break;
				} else if (target[i] != target[i + 1]) {
					copy.remove(target[i].intValue());
					cnt++;
				}
			}
			for (int i = copy.size() - 1; i >= 0; i--) {
				copy.get(i)[0]++;
				if (copy.get(i)[0] >= N) {
					copy.remove(i);
				}
			}
		}
		return cnt;
	}

}
