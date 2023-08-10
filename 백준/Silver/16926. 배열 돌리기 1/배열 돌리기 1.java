import java.util.Scanner;

public class Main {
	static int n, m, k;
	static int[][] map;
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		k = sc.nextInt();
		map = new int[n][m];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		for (int l = 0; l < k; l++) {
			int step = Math.min(n, m) / 2;  // 몇 번 돌릴지 횟수 저장
			for (int d = 0; d < step; d++) {
				// 시작점 설정 
				int startR = d;
				int startC = d;
				
				// 벽이 나오면 방향 전환
				int dir = 0;
				
				// 시작점 값 저장
				int temp = map[startR][startC];
				while(dir < 4) {
					int nr = startR + dr[dir];
					int nc = startC + dc[dir];
					if(nr >= d && nr < n-d && nc >= d && nc < m-d) {
						map[startR][startC] = map[nr][nc];
						startR = nr;
						startC = nc;
					}else dir++;
				}
				
				// 이동이 끝나면, 초기 시작점 값을  마지막 이동 위치에 넣어줌
				map[d+1][d] = temp;
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

}
