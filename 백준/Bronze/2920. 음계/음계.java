import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int cur = Integer.parseInt(st.nextToken());
		if (cur == 1) {
			for (int i = 2; i <= 8; i++) {
				cur = Integer.parseInt(st.nextToken());
				if (cur != i) {
					System.out.println("mixed");
					System.exit(0);
				}
			}
			System.out.println("ascending");
		} else if (cur == 8) {
			for (int i = 2; i <= 8; i++) {
				cur = Integer.parseInt(st.nextToken());
				if (cur != 8 - (i - 1)) {
					System.out.println("mixed");
					System.exit(0);
				}
			}
			System.out.println("descending");
		} else {
			System.out.println("mixed");
		}
		
	}

}
