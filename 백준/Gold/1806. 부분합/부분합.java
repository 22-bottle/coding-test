import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int[] seq = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			seq[i] = Integer.parseInt(st.nextToken());
		}
		int front = 0, rear = 0, sum = seq[0], len = Integer.MAX_VALUE;
		while (rear < N - 1) {
			while (rear < N - 1 && sum < S) {
				sum += seq[++rear];
			}
			while (front < rear && sum - seq[front] >= S) {
				sum -= seq[front++];
			}
			if (sum >= S) len = Integer.min(len, rear - front + 1);
			if (front < rear) sum -= seq[front++];
			else if (rear < N - 1) sum += seq[rear++];
		}
		if (len == Integer.MAX_VALUE) System.out.println(0);
		else System.out.println(len);
		
	}

}