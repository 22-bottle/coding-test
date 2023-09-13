import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, M, board[][];
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());			
			int sum = 0;
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken()) + sum;
				sum = board[i][j];
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int tc = 0; tc < M; tc++) {
			st = new StringTokenizer(br.readLine());
			int s_r = Integer.parseInt(st.nextToken()) - 1;
			int s_c = Integer.parseInt(st.nextToken()) - 1;
			int e_r = Integer.parseInt(st.nextToken()) - 1;
			int e_c = Integer.parseInt(st.nextToken()) - 1;
			int sum = 0;
			for (int i = s_r; i <= e_r; i++) {
				if (s_c == 0) sum += board[i][e_c];
				else sum += board[i][e_c] - board[i][s_c - 1];
			}
			sb.append(sum).append('\n');
		}
		System.out.println(sb);
	}

}
