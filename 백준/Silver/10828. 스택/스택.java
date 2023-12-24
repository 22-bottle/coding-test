import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> stack = new Stack<>();
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String comment = st.nextToken();
			if (comment.equals("push")) {
				stack.push(Integer.parseInt(st.nextToken()));
			} else if (comment.equals("pop")) {
				if (stack.isEmpty()) System.out.println(-1);
				else System.out.println(stack.pop());
			} else if (comment.equals("size")) {
				System.out.println(stack.size());
			} else if (comment.equals("empty")) {
				if (stack.isEmpty()) System.out.println(1);
				else System.out.println(0);
			} else if (comment.equals("top")) {
				if (stack.isEmpty())System.out.println(-1);
				else System.out.println(stack.peek());
			}
		}
		
	}

}
