import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] nums = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(nums);
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int target = Integer.parseInt(st.nextToken());
			int start = 0;
			int end = N - 1;
			boolean result = false;
			while (start <= end) {
				int middle = (start + end) / 2;
				if (nums[middle] == target) {
					result = true;
					break;
				} else if (nums[middle] > target) {
					end = middle - 1;
				} else {
					start = middle + 1;
				}
			}
			if (result) sb.append(1).append('\n');
			else sb.append(0).append('\n');
		}
		System.out.println(sb);
		
	}

}
