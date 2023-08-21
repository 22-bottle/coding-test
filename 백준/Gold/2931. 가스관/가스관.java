import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static StringBuilder sb;
	static int R, C;
	static char[][] map;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};

	public static void main(String[] args) throws Exception {
		//입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C]; //지도
		int[] home = null; //집의 좌표
		for (int i = 0; i < R; i++) {
			char[] temp = br.readLine().toCharArray();
			for (int j = 0; j < C; j++) {
				map[i][j] = temp[j];
				if (map[i][j] == 'M') home = new int[] {i, j};
			}
		}
		
		if (home[0] - 1 >= 0 && (map[home[0] - 1][home[1]] == '|' || map[home[0] - 1][home[1]] == '+' || map[home[0] - 1][home[1]] == '1' || map[home[0] - 1][home[1]] == '4')) move(home[0] - 1, home[1], 0);
		else if (home[1] + 1 < C && (map[home[0]][home[1] + 1] == '-' || map[home[0]][home[1] + 1] == '+' || map[home[0]][home[1] + 1] == '3' || map[home[0]][home[1] + 1] == '4')) move(home[0], home[1] + 1, 1);
		else if (home[0] + 1 < R && (map[home[0] + 1][home[1]] == '|' || map[home[0] + 1][home[1]] == '+' || map[home[0] + 1][home[1]] == '2' || map[home[0] + 1][home[1]] == '3')) move(home[0] + 1, home[1], 2);
		else if (home[1] - 1 >= 0 && (map[home[0]][home[1] - 1] == '-' || map[home[0]][home[1] - 1] == '+' || map[home[0]][home[1] - 1] == '1' || map[home[0]][home[1] - 1] == '2')) move(home[0], home[1] - 1, 3);
		
		System.out.print(sb); //출력
	}

	private static void move(int r, int c, int d) { //길을 따라 한 칸씩 이동하는 함수
		//basis part
		if (map[r][c] == '.') { //길을 따라 왔기 때문에 현재 칸이 빈 칸이면 해당 칸이 지워진 것임
			//현재 칸에서 연결된 칸들을 찾음
			boolean[] connected = new boolean[4];
			if (r - 1 >= 0 && (map[r - 1][c] == '|' || map[r - 1][c] == '+' || map[r - 1][c] == '1' || map[r - 1][c] == '4')) connected[0] = true;
			if (c + 1 < C && (map[r][c + 1] == '-' || map[r][c + 1] == '+' || map[r][c + 1] == '3' || map[r][c + 1] == '4')) connected[1] = true;
			if (r + 1 < R && (map[r + 1][c] == '|' || map[r + 1][c] == '+' || map[r + 1][c] == '2' || map[r + 1][c] == '3')) connected[2] = true;
			if (c - 1 >= 0 && (map[r][c - 1] == '-' || map[r][c - 1] == '+' || map[r][c - 1] == '1' || map[r][c - 1] == '2')) connected[3] = true;
			//연결된 칸에 따라 현재 칸에 들어가야 할 블록을 찾음
			if (connected[0] && !connected[1] && connected[2] && !connected[3]) sb.append((r + 1) + " " + (c + 1) + " |\n");
			else if (!connected[0] && connected[1] && !connected[2] && connected[3]) sb.append((r + 1) + " " + (c + 1) + " -\n");
			else if (connected[0] && connected[1] && connected[2] && connected[3]) sb.append((r + 1) + " " + (c + 1) + " +\n");
			else if (!connected[0] && connected[1] && connected[2] && !connected[3]) sb.append((r + 1) + " " + (c + 1) + " 1\n");
			else if (connected[0] && connected[1] && !connected[2] && !connected[3]) sb.append((r + 1) + " " + (c + 1) + " 2\n");
			else if (connected[0] && !connected[1] && !connected[2] && connected[3]) sb.append((r + 1) + " " + (c + 1) + " 3\n");
			else if (!connected[0] && !connected[1] && connected[2] && connected[3]) sb.append((r + 1) + " " + (c + 1) + " 4\n");
			return;
		}
		//inductive part
		//현재 칸의 블록과 들어온 방향에 따라 다음 칸으로 이동
		if (map[r][c] == '|' || map[r][c] == '-' || map[r][c] == '+') { // |, -, +는 들어온 방향대로 다음 칸으로 이동
			move(r + dr[d], c + dc[d], d);
		} else if (map[r][c] == '1') { //1은
			if (d == 0) move(r, c + 1, 1); //위로 들어와서 오른쪽으로 나가는 경우
			else if (d == 3) move(r + 1, c, 2); //오른쪽으로 들어와서 아래로 나가는 경우
		} else if (map[r][c] == '2') { //2는
			if (d == 2) move(r, c + 1, 1); //아래로 들어와서 오른쪽으로 나가는 경우
			else if (d == 3) move(r - 1, c, 0); //왼쪽으로 들어와서 위로 나가는 경우
		} else if (map[r][c] == '3') { //3은
			if (d == 1) move(r - 1, c, 0); //오른쪽으로 들어와서 위로 나가는 경우
			else if (d == 2) move(r, c - 1, 3); //아래로 들어와서 왼쪽으로 나가는 경우
		} else if (map[r][c] == '4') { //4는
			if (d == 0) move(r, c - 1, 3); //위로 들어와서 왼쪽으로 나가는 경우
			else if (d == 1) move(r + 1, c, 2); //오른쪽으로 들어와서 아래로 나가는 경우
		}
	}

}