import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int cur = 1;
		Stack<Integer> stack = new Stack<>();
		boolean result = true;
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			while (num >= cur) {
				stack.push(cur++);
				sb.append('+').append('\n');
			}
			if (stack.peek() == num) {
				stack.pop();
				sb.append('-').append('\n');
			} else {
				result = false;
			}
		}
		if (result) System.out.println(sb);
		else System.out.println("NO");
		
	}

}