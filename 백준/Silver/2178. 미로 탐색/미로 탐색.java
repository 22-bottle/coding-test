import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M, maze[][], answer = Integer.MAX_VALUE;
	static boolean isVisited[][];
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		maze = new int[N][M];
		isVisited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			String temp = br.readLine();
			for (int j = 0; j < M; j++) {
				maze[i][j] = temp.charAt(j) - '0';
			}
		}
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {0, 0, 1});
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			if (cur[0] == N - 1 && cur[1] == M - 1 && cur[2] < answer) answer = cur[2];
			for (int i = 0; i < 4; i++) {
				if (cur[0] + dr[i] < 0 || cur[0] + dr[i] >= N || cur[1] + dc[i] < 0 || cur[1] + dc[i] >= M) continue;
				if (!isVisited[cur[0] + dr[i]][cur[1] + dc[i]] && maze[cur[0] + dr[i]][cur[1] + dc[i]] == 1) {
					q.offer(new int[] {cur[0] + dr[i], cur[1] + dc[i], cur[2] + 1});
					isVisited[cur[0] + dr[i]][cur[1] + dc[i]] = true;
				}
			}
		}
		System.out.println(answer);
	}

}