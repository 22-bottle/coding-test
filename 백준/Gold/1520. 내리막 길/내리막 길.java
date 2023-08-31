import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int[][] map = new int[R][C];
		List<int[]> list = new ArrayList<>();
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				list.add(new int[] {map[i][j], i, j});
			}
		}
		Collections.sort(list, (o1, o2) -> {return o2[0] - o1[0];});
		int[][] cnt = new int[R][C];
		cnt[0][0] = 1;
		for (int[] l : list) {
			for (int d = 0; d < 4; d++) {
				if (l[1] + dr[d] < 0 || l[1] + dr[d] >= R || l[2] + dc[d] < 0 || l[2] + dc[d] >= C) continue;
				if (map[l[1] + dr[d]][l[2] + dc[d]] < map[l[1]][l[2]]) {
					cnt[l[1] + dr[d]][l[2] + dc[d]] += cnt[l[1]][l[2]];
				}
			}
		}
		System.out.println(cnt[R - 1][C - 1]);
		
	}

}
