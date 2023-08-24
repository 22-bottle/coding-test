import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N, D, K, C, sushi[], eaten[], answer;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken()) - 1;
		sushi = new int[N];
		for (int i = 0; i < N; i++) {
			sushi[i] = Integer.parseInt(br.readLine()) - 1;
		}
		eaten = new int[D];
		eaten[C]++;
		int cnt = 1;
		for (int i = 0; i < K; i++) {
			if (eaten[sushi[i]] == 0) cnt++;
			eaten[sushi[i]]++;
		}
		answer = cnt;
		for (int start = 1; start < N; start++) {
			eaten[sushi[start - 1]]--;
			if (eaten[sushi[start - 1]] == 0) cnt--;
			if (eaten[sushi[(start + K - 1) % N]] == 0) cnt++;
			eaten[sushi[(start + K - 1) % N]]++;
			if (answer < cnt) answer = cnt;
		}
		System.out.println(answer);
		
	}

}
