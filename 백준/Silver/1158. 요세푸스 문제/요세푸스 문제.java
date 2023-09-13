import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int N, K;
	static List<Integer> nums = new ArrayList<>();
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken()) - 1;
		for (int i = 1; i <= N; i++) {
			nums.add(i);
		}
		StringBuilder sb = new StringBuilder("<");
		int idx = K;
		while (!nums.isEmpty()) {
			sb.append(nums.get(idx));
			nums.remove(idx);
			idx += K;
			while (idx >= nums.size() && nums.size() > 0) {
				idx -= nums.size();
			}
			if (nums.size() > 0) sb.append(", ");
		}
		sb.append(">");
		System.out.println(sb);
		
	}

}
