import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int M, N, H, tomato[][][], target = 0, answer;
	static Queue<int[]> tomatoes = new ArrayDeque<>();
	static boolean[][][] visited;
	static int dx[] = {-1, 1, 0, 0, 0, 0};
	static int dy[] = {0, 0, -1, 1, 0, 0};
	static int dz[] = {0, 0, 0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		tomato = new int[H][N][M];
		visited = new boolean[H][N][M];
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < M; k++) {
					tomato[i][j][k] = Integer.parseInt(st.nextToken());
					if (tomato[i][j][k] == 1) {
						tomatoes.offer(new int[] {i, j, k, 0});
						visited[i][j][k] = true;
					}
					else if (tomato[i][j][k] == 0) target++;
				}
			}
		}
		answer = bfs();
		System.out.println(target == 0 ? answer : -1);
		
	}

	private static int bfs() {
		int[] cur = null;
		while (!tomatoes.isEmpty()) {
			cur = tomatoes.poll();
			for (int d = 0; d < 6; d++) {
				int nz = cur[0] + dz[d];
				int nx = cur[1] + dx[d];
				int ny = cur[2] + dy[d];
				if (nz < 0 || nz >= H || nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
				if (!visited[nz][nx][ny] && tomato[nz][nx][ny] == 0) {
					tomatoes.offer(new int[] {nz, nx, ny, cur[3] + 1});
					visited[nz][nx][ny] = true;
					target--;
				}
			}
		}
		if (cur == null) return -1;
		else return cur[3];
	}

}
