import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 10;
		for (int tc = 1; tc <= T; tc++) {
			int ans = 1;
			int N = Integer.parseInt(br.readLine());
			String str = br.readLine();
			Stack<Character> s = new Stack<>();
			for (int i = 0; i < N; i++) {
				if (str.charAt(i) == '(' || str.charAt(i) == '[' || str.charAt(i) == '{' || str.charAt(i) == '<') {
					s.add(str.charAt(i));
				} else if (str.charAt(i) == ')') {
					if (s.peek() != '(') {
						ans = 0;
						break;
					} else s.pop();
				} else if (str.charAt(i) == ']') {
					if (s.peek() != '[') {
						ans = 0;
						break;
					} else s.pop();
				} else if (str.charAt(i) == '}') {
					if (s.peek() != '{') {
						ans = 0;
						break;
					} else s.pop();
				} else if (str.charAt(i) == '>') {
					if (s.peek() != '<') {
						ans = 0;
						break;
					} else s.pop();
				}	
			}
			if (!s.isEmpty()) ans = 0;
			System.out.printf("#%d %d\n", tc, ans);
		}
	}

}