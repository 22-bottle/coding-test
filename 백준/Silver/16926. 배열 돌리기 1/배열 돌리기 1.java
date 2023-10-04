import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, M, R, input[][], result[][];
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		input = new int[N][M];
		result = new int[N][M];
		R = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				input[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int sr = 0; int er = N - 1;
		int sc = 0;	int ec = M - 1;
		while ((er - sr) >= 1 && (ec - sc) >= 1) {
			int cur_re = R % ((er - sr + ec - sc) << 1);
			for (int i = sr ; i <= er; i++) {
				for (int j = sc; j <= ec; j++) {
					if ((i != sr && i != er) && (j != sc && j != ec)) continue;
					int cur_r = i;
					int cur_c = j;
					for (int k = 0; k < cur_re; k++) {
						if (cur_r == sr && cur_c != sc) {
							cur_c--;
						} else if (cur_r != er && cur_c == sc) {
							cur_r++;
						} else if (cur_r == er && cur_c != ec) {
							cur_c++;
						} else if (cur_r != sr && cur_c == ec) {
							cur_r--;
						}
					}
					result[cur_r][cur_c] = input[i][j];
				}
			}
			sr++; sc++;
			er--; ec--;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(result[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
		
	}

}
