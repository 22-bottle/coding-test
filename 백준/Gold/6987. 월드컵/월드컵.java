import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static boolean answer;
	static int[][] table;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < 4; t++) {
			answer = false;
			table = new int[6][3];
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < 6; i++) {
				for (int j = 0; j < 3; j++) {
					table[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			next_match(1, 0, 1);
			if (answer) sb.append("1").append(" ");
			else sb.append("0").append(" ");
		}
		System.out.println(sb);
	}
	
	private static void next_match(int round, int a, int b) {
		//basis
		if (round > 15) {
			int sum = 0;
			for (int i = 0; i < 6; i++) {
				for (int j = 0; j < 3; j++) {
					sum += table[i][j];
				}
			}
			if (sum == 0) answer = true;
			return;
		}
		//inductive
		//a팀 승
		if (table[a][0] > 0 && table[b][2] > 0) {
			table[a][0]--;
			table[b][2]--;
			if (b == 5) next_match(round + 1, a + 1, a + 2);
			else next_match(round + 1, a, b + 1);
			table[a][0]++;
			table[b][2]++;
		}
		//무
		if (table[a][1] > 0 && table[b][1] > 0) {
			table[a][1]--;
			table[b][1]--;
			if (b == 5) next_match(round + 1, a + 1, a + 2);
			else next_match(round + 1, a, b + 1);
			table[a][1]++;
			table[b][1]++;
		}
		//a팀 패
		if (table[a][2] > 0 && table[b][0] > 0) {
			table[a][2]--;
			table[b][0]--;
			if (b == 5) next_match(round + 1, a + 1, a + 2);
			else next_match(round + 1, a, b + 1);
			table[a][2]++;
			table[b][0]++;
		}
	}

}