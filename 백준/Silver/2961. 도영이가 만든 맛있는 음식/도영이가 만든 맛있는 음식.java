import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N, S[], B[];

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		S = new int[N];
		B = new int[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			S[i] = Integer.parseInt(st.nextToken());
			B[i] = Integer.parseInt(st.nextToken());
		}
		int answer = Integer.MAX_VALUE;
		for (int i = 1; i < (1 << N); i++) {
			int sour = 1;
			int bitter = 0;
			for (int j = 0; j < N; j++) {
				if ((i & (1 << j)) != 0) {
					sour *= S[j];
					bitter += B[j];
				}
			}
			answer = Math.min(answer, Math.abs(sour - bitter));
		}
		System.out.println(answer);
		
	}

}
