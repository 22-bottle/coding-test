import java.util.*;
public class Main {
	static int n, answer;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		answer = Integer.MAX_VALUE;
		
		func(5,3);
		func(3,5);
		if(answer == Integer.MAX_VALUE) {
			System.out.println(-1);
		}else System.out.println(answer);
	}
	
	private static void func(int num1, int num2) {
		for (int i = 1; i <= (n / num1); i++) {
			if((n - num1*i) % num2 == 0) {
				int tempN = n - num1*i;
				int temp = tempN / num2;
				answer = Math.min(answer, temp+i);
			}
		}
	}
}
