import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N, B, C, rooms[];
	static long answer;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		rooms = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			rooms[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		answer = 0;
		for (int i = 0; i < N; i++) {
			rooms[i] -= B;
			answer++;
			if (rooms[i] > 0) {
				answer += rooms[i] / C;
				if (rooms[i] % C != 0) answer++;
			}
		}
		System.out.println(answer);
		
	}

}
