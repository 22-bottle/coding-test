import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int num, r, c;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		num = 0;
		quarter(1 << N, 0, 0);
		
	}
	
	private static void quarter(int side, int cur_r, int cur_c) {
		if (side == 1) {
			if (cur_r == r && cur_c == c) {
				System.out.println(num);
			}
			num++;
			return;
		}
		int half = side / 2;
		if (r >= cur_r + half && c >= cur_c + half) {
			num += (half * half) * 3;
			quarter(half, cur_r + half, cur_c + half);
		} else if (r >= cur_r + half) {
			num += (half * half) * 2;
			quarter(half, cur_r + half, cur_c);
		} else if (c >= cur_c + half) {
			num += (half * half);
			quarter(half, cur_r, cur_c + half);
		} else {
			quarter(half, cur_r, cur_c);
		}
	}

}