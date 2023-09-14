import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	static int N;
	static String[] first = {"2", "3", "5", "7"};
	static String[] second = {"1", "3", "5", "7", "9"};
	static String num;
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		sb = new StringBuilder();
		for (int i = 0; i < 4; i++) {
			num = first[i];
			perm(1);
		}
		System.out.println(sb);
		
	}
	
	public static void perm(int idx) {
		if (idx == N) {
			sb.append(num).append('\n');
			return;
		}
		for (int i = 0; i < 5; i++) {
			String temp = num + second[i];
			if (!isPrime(Integer.parseInt(temp))) {
				continue;
			}
			num = temp;
			perm(idx + 1);
			if (num.length() > 1) {
				num = num.substring(0, num.length() - 1);
			}
		}
	}
	
	public static boolean isPrime(int n) {
		for (int i = 2; i * i <= n; i++) {
			if (n % i == 0) return false;
		}
		return true;
	}

}
