import java.util.*;

public class Main {
	static int n;
	static char[][] map;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		map = new char[n][n];
		
		for (int i = 0; i < n; i++) {
			map[i] = sc.next().toCharArray();
		}
		quadTree(0, 0, n);
		
	}
	
	private static void quadTree(int r, int c, int size) {
		
		if(checkNum(r, c, size)) {
			if(map[r][c] == '0') System.out.print(0);
			else System.out.print(1);
			return;
		}
		
		int newSize = size / 2;
		System.out.print("(");
		quadTree(r, c, newSize);  // 2사분면
		quadTree(r, c+newSize, newSize);  // 1사분면
		quadTree(r+newSize, c, newSize);  // 3사분면
		quadTree(r+newSize, c+newSize, newSize);  // 4사분면
		System.out.print(")");
	}
	
	private static boolean checkNum(int r, int c, int size) {
		char firstNum = map[r][c];
		
		for (int row = r; row < r+size; row++) {
			for (int col = c; col < c+size; col++) {
				if(map[row][col] != firstNum) {
					return false;
				}
			}
		}
		return true;
	}

}
