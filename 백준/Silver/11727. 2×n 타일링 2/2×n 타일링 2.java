import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] mem = new int[1001];
		mem[1] = 1;
		mem[2] = 3;
		for (int i = 3; i <= N; i++) {
			mem[i] = (mem[i - 1] + (mem[i - 2] * 2)) % 10007;
		}
		System.out.println(mem[N]);
		
	}

}