import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<Integer> q = new ArrayDeque<>();
		int N = Integer.parseInt(br.readLine());
		for (int i = 1; i <= N; i++) {
			q.offer(i);
		}
		for (int i = 0; i < N - 1; i++) {
			q.poll();
			q.add(q.poll());
		}
		System.out.println(q.peek());
	}

}
