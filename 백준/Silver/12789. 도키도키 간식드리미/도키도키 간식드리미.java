import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static Queue<Integer> q = new ArrayDeque<>();
	static Stack<Integer> s = new Stack<>();

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			q.offer(Integer.parseInt(st.nextToken()));
		}
		for (int i = 1; i <= N; i++) {
			if (!q.isEmpty() && q.peek() == i) {
				q.poll();
			} else if (!s.isEmpty() && s.peek() == i) {
				s.pop();
			} else {
				while (!q.isEmpty() && q.peek() != i) {
					s.push(q.poll());
				}
				q.poll();
			}
		}
		if (!s.isEmpty()) System.out.println("Sad");
		else System.out.println("Nice");
		
	}

}
