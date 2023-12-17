import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Main {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			boolean palindrome = true;
			String str = br.readLine();
			if (str.equals("0")) break;
			int front = 0;
			int rear = str.length() - 1;
			while (front < rear) {
				if (str.charAt(front) != str.charAt(rear)) {
					palindrome = false;
					break;
				}
				front++;
				rear--;
			}
			if (palindrome) System.out.println("yes");
			else System.out.println("no");
		}
		
	}

}