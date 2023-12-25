import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int T, N, M, cnt;
	static Queue<int[]> printer;
	static int[] docs;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			printer = new ArrayDeque<>();
			docs = new int[10];
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				int p = Integer.parseInt(st.nextToken());
				printer.add(new int[] {i, p});
				docs[p]++;
			}
			cnt = 0;
			while (true) {
				int[] cur = printer.poll();
				boolean check = true;
				for (int p = 9; p > cur[1]; p--) {
					if (docs[p] > 0) {
						check = false;
						break;
					}
				}
				if (!check) {
					printer.add(cur);
				} else {
					if (cur[0] == M) {
						System.out.println(cnt + 1);
						break;
					} else {
						docs[cur[1]]--;
						cnt++;
					}
				}
			}
		}
		
	}

}
