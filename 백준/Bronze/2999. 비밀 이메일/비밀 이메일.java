import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String message = br.readLine();
		int N = message.length();
		int R = (int)Math.sqrt(N);
		while (N % R != 0) {
			R--;
		}
		int C = N / R;
		char[][] matrix = new char[R][C];
		int idx = 0;
		for (int i = 0; i < C; i++) {
			for (int j = 0; j < R; j++) {
				matrix[j][i] = message.charAt(idx++);
			}
		}
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(matrix[i][j]);
			}
		}
	}

}
