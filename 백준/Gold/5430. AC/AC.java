import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static int T, N;
	static String command, nums;
	static List<Integer> array;
	static boolean backward, error;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			command = br.readLine();
			N = Integer.parseInt(br.readLine());
			array = new ArrayList<>();
			nums = br.readLine();
			nums = nums.substring(1, nums.length() - 1);
			StringTokenizer st = new StringTokenizer(nums, ",");
			for (int i = 0; i < N; i++) {
				array.add(Integer.parseInt(st.nextToken()));
			}
			backward = false;
			error = false;
			for (int i = 0; i < command.length(); i++) {
				if (command.charAt(i) == 'R') {
					backward = !backward;
				} else {
					if (array.isEmpty()) {
						error = true;
						break;
					}
					if (backward) array.remove(array.size() - 1);
					else array.remove(0);
				}
			}
			if (error) System.out.println("error");
			else {
				StringBuilder sb = new StringBuilder();
				sb.append('[');
				if (backward) {
					for (int i = array.size() - 1; i >= 0; i--) {
						sb.append(array.get(i)).append(',');
					}
				}
				else for (int i : array) sb.append(i).append(',');
				if (array.size() > 0) sb.deleteCharAt(sb.length() - 1);
				sb.append(']');
				System.out.println(sb);
			}
		}
		
	}

}