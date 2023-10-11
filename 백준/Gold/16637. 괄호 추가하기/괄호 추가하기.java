import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class Main {
	
	static int N, answer = Integer.MIN_VALUE;
	static boolean[] first;
	static char[] operators;
	static ArrayDeque<Integer> operands = new ArrayDeque<>(), temp;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		first = new boolean[N / 2];
		operators = new char[N / 2];
		String temp = br.readLine();
		for (int i = 0, idx = 0; i < N; i++) {
			if (i % 2 == 0) operands.offer(temp.charAt(i) - '0');
			else operators[idx++] = temp.charAt(i);
 		}
		choose(0);
		System.out.println(answer);
		
	}

	private static void choose(int idx) {
		if (idx >= operators.length) {
			answer = Math.max(answer, calculate());
			return;
		}
		choose(idx + 1);
		first[idx] = true;
		choose(idx + 2);
		first[idx] = false;
	}

	private static int calculate() {
		temp = new ArrayDeque<>();
		for (int i = 0; i < operands.size(); i++) {
			int op = operands.poll();
			temp.offer(op);
			operands.offer(op);
		}
		for (int i = 0; i < first.length; i++) {
			if (first[i]) {
				int op1 = temp.poll();
				int op2 = temp.poll();
				if (operators[i] == '+') temp.offerFirst(op1 + op2);
				else if (operators[i] == '-') temp.offerFirst(op1 - op2);
				else if (operators[i] == '*') temp.offerFirst(op1 * op2);
			} else temp.offer(temp.poll());
		}
		temp.offer(temp.poll());
		for (int i = 0; i < first.length; i++) {
			if (!first[i]) {
				int op1 = temp.poll();
				int op2 = temp.poll();
				if (operators[i] == '+') temp.offerFirst(op1 + op2);
				else if (operators[i] == '-') temp.offerFirst(op1 - op2);
				else if (operators[i] == '*') temp.offerFirst(op1 * op2);
			}
		}
		return temp.poll();
	}

}
