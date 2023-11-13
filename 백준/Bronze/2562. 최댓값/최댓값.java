import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static int[] nums = new int[10];
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int max_value = 0;
		int max_index = 0;
		for (int i = 1; i <= 9; i++) {
			nums[i] = Integer.parseInt(br.readLine());
			if (nums[i] > max_value) {
				max_value = nums[i];
				max_index = i;
			}
		}
		System.out.println(max_value);
		System.out.println(max_index);
		
	}

}
