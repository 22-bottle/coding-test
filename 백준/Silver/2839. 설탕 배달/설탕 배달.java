import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int _5kg = N / 5;
		int left = N % 5;
		while (left % 3 != 0 && _5kg >= 0) {
			_5kg--;
			left += 5;
		}
		if (_5kg < 0) System.out.println(-1);
		else {
			int _3kg = left / 3;
			System.out.println(_5kg + _3kg);
		}
	}

}