import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static boolean[] broken = new boolean[10];

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		if (M != 0)	st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			broken[Integer.parseInt(st.nextToken())] = true;
		}
		int diff = 0;
		int digit = 0;
		while (diff < Math.abs(N - 100)) {
			int lower = N - diff;
			int upper = N + diff;
			if (lower >= 0 && !isBroken(lower)) {
				digit = getDigit(lower);
				break;
			}
			if (!isBroken(upper)) {
				digit = getDigit(upper);
				break;
			}
			diff++;
		}
		System.out.println(Math.min(diff + digit, Math.abs(N - 100)));
		
	}
	
	private static boolean isBroken(int num) {
		if (num == 0 && broken[0]) return true;
		while (num > 0) {
			if (broken[num % 10]) return true;
			num /= 10;
		}
		return false;
	}
	
	private static int getDigit(int num) {
		if (num == 0) return 1;
		int count = 0;
		while (num > 0) {
			num /= 10;
			count++;
		}
		return count;
	}

}
