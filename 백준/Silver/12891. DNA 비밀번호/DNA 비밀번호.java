import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int S, P, condition[], cnt[], answer;
	static char[] str;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		S = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		str = br.readLine().toCharArray();
		condition = new int[4];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			condition[i] = Integer.parseInt(st.nextToken());
		}
		cnt = new int[4];
		for (int i = 0; i < P; i++) {
			switch (str[i]) {
			case 'A':
				cnt[0]++;
				break;
			case 'C':
				cnt[1]++;
				break;
			case 'G':
				cnt[2]++;
				break;
			case 'T':
				cnt[3]++;
				break;
			}
		}
		if (confirm()) answer = 1;
		else answer = 0;
		
		for (int i = P; i < S; i++) {
			switch (str[i - P]) {
			case 'A':
				cnt[0]--;
				break;
			case 'C':
				cnt[1]--;
				break;
			case 'G':
				cnt[2]--;
				break;
			case 'T':
				cnt[3]--;
				break;
			}
			switch (str[i]) {
			case 'A':
				cnt[0]++;
				break;
			case 'C':
				cnt[1]++;
				break;
			case 'G':
				cnt[2]++;
				break;
			case 'T':
				cnt[3]++;
				break;
			}
			if (confirm()) answer++;
		}
		System.out.println(answer);
		
	}
	
	public static boolean confirm() {
		for (int i = 0; i < 4; i++) {
			if (cnt[i] < condition[i]) return false;
		}
		return true;
	}

}
