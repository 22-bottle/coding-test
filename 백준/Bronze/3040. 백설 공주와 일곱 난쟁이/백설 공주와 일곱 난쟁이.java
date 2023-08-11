import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[9];
		
		for (int i = 0; i < 9; i++) {
			arr[i] = sc.nextInt();
		}
		
		recursive(arr, new int[7], 0, 0, 0);
		
	}
	private static void recursive(int[] arr, int[] sel, int idx, int k, int sum) {
		if(k == sel.length) {
			if(sum == 100) {
				for (int i = 0; i < sel.length; i++) {
					System.out.println(sel[i]);
				}
			}
			return;
		}

		for(int i = idx; i < arr.length; i++){
			sel[k] = arr[i];
			recursive(arr, sel, i+1, k+1, sum+arr[i]);
		}
	}
}
