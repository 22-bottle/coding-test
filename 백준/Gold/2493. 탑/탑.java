import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] ans = new int[N];
		ans[0] = 0;
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Stack<Integer> s = new Stack<>();
		s.add(0);
		s.add(arr[0]);
		for (int i = 1; i < N; i++) {
			while (!s.isEmpty() && s.peek() < arr[i]) {
				s.pop();
				s.pop();
			}
			if (s.isEmpty()) {
				ans[i] = 0;
				s.add(i);
				s.add(arr[i]);
			} else {
				int temp = s.pop();
				ans[i] = s.peek() + 1;
				s.add(temp);
				s.add(i);
				s.add(arr[i]);
			}
		}
		
		for (int i = 0; i < N; i++) {
			System.out.print(ans[i] + " ");
		}
	}

}