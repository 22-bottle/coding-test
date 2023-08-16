import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	static StringBuilder sb;
	static int[][] video;
	static boolean is_zero, is_one;
	static int[] quardrant;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		video = new int[N][N];
		for (int i = 0; i < N; i++) {
			String[] temp = br.readLine().split("");
			for (int j = 0; j < N; j++) {
				video[i][j] = Integer.parseInt(temp[j]);
			}
		}
		
		sb = new StringBuilder();
		quardrant = new int[4];
		can_zip(0, 0, N);
		System.out.println(sb);
	}
	
	private static void can_zip(int r, int c, int side) {
		if (side == 1) {
			sb.append(video[r][c]);
			return;
		}
		for (int i = 0; i < 4; i++) {
			quardrant[i] = -5;
		}
		int half = side >> 1;
		
		is_zero = false;
		is_one = false;
		for (int i = r; i < r + half; i++) {
			for (int j = c; j < c + half; j++) {
				if (video[i][j] == 0) is_zero = true;
				else is_one = true;
				if (is_zero && is_one) break;
			}
			if (is_zero && is_one) break;
		}
		if (is_zero && !is_one) quardrant[0] = 0;
		else if (!is_zero && is_one) quardrant[0] = 1;
		
		is_zero = false;
		is_one = false;
		for (int i = r; i < r + half; i++) {
			for (int j = c + half; j < c + half * 2; j++) {
				if (video[i][j] == 0) is_zero = true;
				else is_one = true;
				if (is_zero && is_one) break;
			}
			if (is_zero && is_one) break;
		}
		if (is_zero && !is_one) quardrant[1] = 0;
		else if (!is_zero && is_one) quardrant[1] = 1;
		
		is_zero = false;
		is_one = false;
		for (int i = r + half; i < r + half * 2; i++) {
			for (int j = c; j < c + half; j++) {
				if (video[i][j] == 0) is_zero = true;
				else is_one = true;
				if (is_zero && is_one) break;
			}
			if (is_zero && is_one) break;
		}
		if (is_zero && !is_one) quardrant[2] = 0;
		else if (!is_zero && is_one) quardrant[2] = 1;
		
		is_zero = false;
		is_one = false;
		for (int i = r + half; i < r + half * 2; i++) {
			for (int j = c + half; j < c + half * 2; j++) {
				if (video[i][j] == 0) is_zero = true;
				else is_one = true;
				if (is_zero && is_one) break;
			}
			if (is_zero && is_one) break;
		}
		if (is_zero && !is_one) quardrant[3] = 0;
		else if (!is_zero && is_one) quardrant[3] = 1;
		
		int sum = 0;
		for (int i = 0; i < 4; i++) {
			sum += quardrant[i];
		}
		if (sum == 0) sb.append(0);
		else if (sum == 4) sb.append(1);
		else {
			sb.append("(");
			can_zip(r, c, half);
			can_zip(r, c + half, half);
			can_zip(r + half, c, half);
			can_zip(r + half, c + half, half);
			sb.append(")");
		}
	}

}