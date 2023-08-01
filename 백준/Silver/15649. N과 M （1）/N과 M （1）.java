import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int M;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int[] arr = new int[M];
		boolean[] isSelected = new boolean[N + 1];
		perm(arr, isSelected, 0);
	}
	
	public static void perm(int[] arr, boolean[] isSelected, int idx) {
		if (idx == M) {
			for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
			return;
		}
		for (int i = 1; i <= N; i++) {
			if (!isSelected[i]) {
				arr[idx] = i;
				isSelected[i] = true;
				perm(arr, isSelected, idx + 1);
				isSelected[i] = false;
			}
		}
	}

}