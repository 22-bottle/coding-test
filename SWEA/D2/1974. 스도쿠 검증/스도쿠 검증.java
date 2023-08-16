import java.util.*;

public class  Solution{
	static int[][] map = new int[9][9];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		for (int tc = 1; tc <= t; tc++) {
			int answer = 1;
			
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			for (int row = 0; row < 9; row++) {
				int rowSum = 0;
				int colSum = 0;
				for (int col = 0; col < 9; col++) {
					rowSum += map[row][col];
					colSum += map[col][row];
				}
				if(rowSum != 45 || colSum != 45) {
					answer = 0;
					break;
				}
			}
			
			for (int i = 0; i < 9; i+=3) {
				for (int j = 0; j < 9; j+=3) {
					int arrSum = 0;
					for (int x = i; x < i+3; x++) {
						for (int y = j; y < j+3; y++) {
							arrSum += map[x][y];
						}
					}					
					if(arrSum != 45) {
						answer = 0;
						break;
					}
				}
			}
			System.out.println("#" + tc + " " + answer);
		}
	}
}
