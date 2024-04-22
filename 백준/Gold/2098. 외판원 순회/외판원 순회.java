import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int[][] dist, mem, path;
	static final int INF = 16_000_000;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		dist = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				dist[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int size = 1 << (N - 1);
		mem = new int[N][size];
		path = new int[N][size];
		for (int i = 1; i < N; i++) {
			if (dist[i][0] == 0) mem[i][0] = INF;
			else mem[i][0] = dist[i][0];
		}
		for (int k = 1; k < N; k++) {
			for (int A = 1; A < size - 1; A++) {
				if (count(A) == k) {
					for (int i = 0; i < N - 1; i++) { //i + 1번째 노드가 포함되는지
						if ((A & (1 << i)) == 0) {
							minimum(i + 1, A);
						}
					}
				}
			}
		}
		minimum(0, size - 1);
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < size; j++) {
//				System.out.print(path[i][j] + " ");
//			}
//			System.out.println();
//		}
		System.out.println(mem[0][size - 1]);
		
	}
	
	private static void minimum(int i, int A) {
		int minValue = INF;
		int minJ = 0;
		for (int j = 0; j < N - 1; j++) {
			if ((A & (1 << j)) != 0) {
				if (dist[i][j + 1] == 0) continue;
				int m = dist[i][j + 1] + mem[j + 1][diff(A, j)];
				if (minValue > m) {
					minValue = m;
					minJ = j + 1;
				}
			}
		}
		mem[i][A] = minValue;
		path[i][A] = minJ;
	}
	
	private static int diff(int A, int j) {
		int t = 1 << j;
		return (A & (~t));
	}
	
	private static int count(int A) {
		int count = 0;
		for (int i = 0; i < N; i++) {
			if ((A & (1 << i)) != 0) {
				count++;
			}
		}
		return count;
	}

}
