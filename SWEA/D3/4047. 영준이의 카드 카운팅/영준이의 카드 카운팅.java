import java.util.*;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		for (int tc = 1; tc <= t; tc++) {
			int S, D, H, C;
			S = D = H = C = 13;
			String str = sc.next();
			String[] arr = str.split("");
			HashSet<String> set = new HashSet<String>();
			int size = arr.length;
			
			for (int i = 0, j = 3; i <= str.length() - 3; i+=3, j+=3) {
					set.add(str.substring(i, j));					
			}
			
			if(size / 3 != set.size()) {
				System.out.println("#"+ tc + " ERROR");
				continue;
			}
			for (int i = 0; i < arr.length; i+=3) {
				switch (arr[i]) {
				case "S":
					S--;
					break;
				case "D":
					D--;
					break;
				case "H":
					H--;
					break;
				case "C":
					C--;
					break;
				}
			}
			System.out.println("#" + tc + " " + S + " " + D + " " + H + " " + C);
		}
	}
}