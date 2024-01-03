import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] player = new int[N];
		int MAX = 1000001;
		boolean[] card = new boolean[MAX];
		int[] score = new int[MAX];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			player[i] = Integer.parseInt(st.nextToken());
			card[player[i]] = true;
		}
		for (int i = 0; i < N; i++) {
			int cur = player[i];
			for (int j = cur * 2; j < MAX; j += cur) {
				if (card[j]) {
					score[cur]++;
					score[j]--;
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int p : player) {
			sb.append(score[p]).append(' ');
		}
		System.out.println(sb);
		
	}

}