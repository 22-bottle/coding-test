import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M, buses[][];

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		buses = new int[N][N];
		for (int i = 0; i < N; i++) {
			Arrays.fill(buses[i], Integer.MAX_VALUE >> 2);
		}
		M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken()) - 1;
			int d = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken());
			if (buses[s][d] > c) buses[s][d] = c;
		}
		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				if (i == k) continue;
				for (int j = 0; j < N; j++) {
					if (j == k || j == i) continue;
					buses[i][j] = Math.min(buses[i][j], buses[i][k] + buses[k][j]);
				}
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print((buses[i][j] != (Integer.MAX_VALUE >> 2) ? buses[i][j] : 0) + " ");
			}
			System.out.println();
		}
		
		
	}

}
