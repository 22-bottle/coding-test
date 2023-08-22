import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static StringBuilder sb;
	static int L, C;
	static char[] letters, sel;
	static char[] vowels = {'a', 'e', 'i', 'o', 'u'};
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		letters = new char[C];
		sel = new char[L];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < C; i++) {
			letters[i] = st.nextToken().charAt(0);
		}
		Arrays.sort(letters);
		comb(0, 0);
		System.out.println(sb);
		
	}

	private static void comb(int n, int idx) {
		if (n == L) {
			int num = cnt_vowel();
			if (num >= 1 && L - num >= 2) {
				for (int i = 0; i < L; i++) {
					sb.append(sel[i]);
				}
				sb.append('\n');
			}
			return;
		}
		for (int i = idx; i < C; i++) {
			sel[n] = letters[i];
			comb(n + 1, i + 1);
		}
	}

	private static int cnt_vowel() {
		int cnt = 0;
		for (int i = 0; i < L; i++) {
			for (int j = 0; j < 5; j++) {
				if (sel[i] == vowels[j]) {
					cnt++;
				}
			}
		}
		return cnt;
	}

}
