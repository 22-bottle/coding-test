import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int S, switches[];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		S = Integer.parseInt(br.readLine());
		switches = new int[S + 1];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= S; i++) {
			switches[i] = Integer.parseInt(st.nextToken());
		}
		int student = Integer.parseInt(br.readLine());
		for (int i = 0; i < student; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int gender = Integer.parseInt(st.nextToken());
			int number = Integer.parseInt(st.nextToken());
			if (gender == 1) {
				int target = number;
				while (target <= S) {
					switches[target] = (switches[target] + 1) % 2;
					target += number;
				}
			} else {
				switches[number] = (switches[number] + 1) % 2;
				compare(number, 1);
			}
		}
		for (int i = 0; i < 5; i++) {
			for (int j = 1; j <= 20; j++) {
				if (i * 20 + j <= S)
					System.out.print(switches[i * 20 + j] + " ");
				else break;
			}
			System.out.println();
		}
	}
	
	private static void compare(int mid, int weight) {
		if (mid - weight <= 0 || mid + weight > S || switches[mid - weight] != switches[mid + weight]) {
			return;
		}
		switches[mid - weight] = (switches[mid - weight] + 1) % 2;
		switches[mid + weight] = (switches[mid + weight] + 1) % 2;
		compare(mid, weight + 1);
	}

}
