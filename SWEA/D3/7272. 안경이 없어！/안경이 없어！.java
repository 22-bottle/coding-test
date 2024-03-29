package swea7272;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution {

	public static void main(String args[]) throws Exception {
		
		System.setIn(new FileInputStream("src/swea7272/input.txt"));
		
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		
		int[] alphabet = {2, 3, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1}; // 경근이가 인식하는 알파벳 종류
		for(int test_case = 1; test_case <= T; test_case++) {
			String str1 = sc.next();
			String str2 = sc.next();
			
			if (str1.length() != str2.length()) { // 두 문자열의 길이가 다른 경우
				System.out.printf("#%d DIFF\n", test_case);
				continue;
			}
			
			boolean isSame = true;
			for (int i = 0; i < str1.length(); i++) { // 문자 하나씩 비교
				int alpha1 = alphabet[str1.charAt(i) - 'A'];
				int alpha2 = alphabet[str2.charAt(i) - 'A'];
				if (alpha1 != alpha2) {
					isSame = false;
					break;
				}
			}
			
			if (isSame) System.out.printf("#%d SAME\n", test_case);
			else System.out.printf("#%d DIFF\n", test_case);
		}
	}

}
