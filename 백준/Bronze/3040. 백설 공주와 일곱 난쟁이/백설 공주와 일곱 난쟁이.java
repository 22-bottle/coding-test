import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	static int[] drawfs, sel;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		drawfs = new int[9];
		sel = new int[7];
		for (int i = 0; i < 9; i++) {
			drawfs[i] = Integer.parseInt(br.readLine());
		}
		comb(0, 0);
	}
	
	private static void comb(int cnt, int start) {
		if (cnt == 7) {
			if (sum() == 100) {
				for (int drawf: sel) {
					System.out.println(drawf);
				}
			}
			return;
		}
		for (int i = start; i < 9; i++) {
			sel[cnt] = drawfs[i];
			comb(cnt + 1, i + 1);
		}
	}
	
	private static int sum() {
		int sum = 0;
		for (int drawf: sel) {
			sum += drawf;
		}
		return sum;
	}

}
