import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static class Node {
		int data;
		Node prev;
		
		public Node(int data) {
			this.data = data;
			this.prev = null;
		}
	}
	
	static class MyStack {
		Node top;
		int size;
		
		public MyStack() {
			this.top = null;
			this.size = 0;
		}
		
		private void push(int data) {
			Node newNode = new Node(data);
			newNode.prev = this.top;
			this.top = newNode;
			size++;
		}
		private boolean isEmpty() {
			if (size == 0) return true;
			else return false;
		}
		private int pop() {
			if (isEmpty()) return -1;
			int data = this.top.data;
			this.top = this.top.prev;
			size--;
			return data;
		}
		private int size() {
			return this.size;
		}
		private int peek() {
			if (isEmpty()) return -1;
			return this.top.data;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		
		MyStack ms = new MyStack();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int command = Integer.parseInt(st.nextToken());
			switch (command) {
			case 1:
				ms.push(Integer.parseInt(st.nextToken()));
				break;
			case 2:
				if (ms.isEmpty()) sb.append(-1).append("\n");
				else sb.append(ms.pop()).append("\n");
				break;
			case 3:
				sb.append(ms.size()).append("\n");
				break;
			case 4:
				if (ms.isEmpty()) sb.append(1).append("\n");
				else sb.append(0).append("\n");
				break;
			case 5:
				if (ms.isEmpty()) sb.append(-1).append("\n");
				else sb.append(ms.peek()).append("\n");
				break;
			}
		}
		System.out.println(sb);
	}

}
