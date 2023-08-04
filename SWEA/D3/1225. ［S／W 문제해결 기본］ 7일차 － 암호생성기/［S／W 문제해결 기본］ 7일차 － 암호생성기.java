import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 10;
		for (int tc = 1; tc <= T; tc++) {
			int t = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			Queue<Integer> q = new ArrayDeque<>();
			for (int i = 0; i < 8; i++) {
				q.offer(Integer.parseInt(st.nextToken()));
			}
			boolean flag = false;
			while (!flag) {
				for (int j = 1; j <= 5; j++) {
					if (q.peek() - j <= 0) {
						flag = true;
						q.offer(0);
						q.poll();
						break;
					}
					q.offer(q.peek() - j);
					q.poll();
				}
			}
			System.out.printf("#%d ", tc);
			for (int i = 0; i < 8; i++) {
				System.out.printf("%d ", q.poll());
			}
			System.out.println();
		}
	}

}