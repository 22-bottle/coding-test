import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int k;
	static int[][] paper;
	static String[] fold;

	public static void main(String[] args) throws Exception {
		//입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		k = Integer.parseInt(br.readLine());
		int top = 1, left = 1;
		int bottom = 1 << k, right = 1 << k;
		paper = new int[bottom + 1][right + 1];
		fold = new String[2 * k];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < 2 * k; i++) {
			fold[i] = st.nextToken();
			//시작 위치 조정
			if (fold[i].equals("D")) {
				int half = (bottom - top + 1) / 2;
				top += half;
			} else if (fold[i].equals("U")) {
				int half = (bottom - top + 1) / 2;
				bottom -= half;
			} else if (fold[i].equals("R")) {
				int half = (right - left + 1) / 2;
				left += half;
			}
			else if (fold[i].equals("L")) {
				int half = (right - left + 1) / 2;
				right -= half;
			}
		}
		paper[top][left] = Integer.parseInt(br.readLine());
		
		unfold(2 * k - 1, top, bottom, left, right);
	}
	
	private static void unfold(int n, int top, int bottom, int left, int right) { //편 횟수와 현재 범위를 가지고 한 번 펼치는 함수
		//basis
		//출력
		if (n < 0) {
			StringBuilder sb = new StringBuilder();
			for (int i = 1; i <= (1 << k); i++) {
				for (int j = 1; j <= (1 << k); j++) {
					sb.append(paper[i][j]).append(" ");
				}
				sb.append("\n");
			}
			System.out.print(sb);
			return;
		}
		//inductive
		if (fold[n].equals("D")) { // D라면 위로 펼침
			int diff = bottom - top + 1;
			for (int i = 0; i < diff; i++) {
				for (int j = left; j <= right; j++) {
					if (paper[top + i][j] == 0) paper[top - 1 - i][j] = 2;
					else if (paper[top + i][j] == 1) paper[top - 1 - i][j] = 3;
					else if (paper[top + i][j] == 2) paper[top - 1 - i][j] = 0;
					else if (paper[top + i][j] == 3) paper[top - 1 - i][j] = 1;
				}
			}
			top -= diff;
		} else if (fold[n].equals("U")) { //U라면 아래로 펼침
			int diff = bottom - top + 1;
			for (int i = 0; i < diff; i++) {
				for (int j = left; j <= right; j++) {
					if (paper[top + i][j] == 0) paper[bottom + diff - i][j] = 2;
					else if (paper[top + i][j] == 1) paper[bottom + diff - i][j] = 3;
					else if (paper[top + i][j] == 2) paper[bottom + diff - i][j] = 0;
					else if (paper[top + i][j] == 3) paper[bottom + diff - i][j] = 1;
				}
			}
			bottom += diff;
		} else if (fold[n].equals("R")) { //R이라면 왼쪽으로 펼침
			int diff = right - left + 1;
			for (int i = top; i <= bottom; i++) {
				for (int j = 0; j < diff; j++) {
					if (paper[i][left + j] == 0) paper[i][left - 1 - j] = 1;
					else if (paper[i][left + j] == 1) paper[i][left - 1 - j] = 0;
					else if (paper[i][left + j] == 2) paper[i][left - 1 - j] = 3;
					else if (paper[i][left + j] == 3) paper[i][left - 1 - j] = 2;
				}
			}
			left -= diff;
		} else if (fold[n].equals("L")) { //L이라면 오른쪽으로 펼침
			int diff = right - left + 1;
			for (int i = top; i <= bottom; i++) {
				for (int j = 0; j < diff; j++) {
					if (paper[i][left + j] == 0) paper[i][right + diff - j] = 1;
					else if (paper[i][left + j] == 1) paper[i][right + diff - j] = 0;
					else if (paper[i][left + j] == 2) paper[i][right + diff - j] = 3;
					else if (paper[i][left + j] == 3) paper[i][right + diff - j] = 2;
				}
			}
			right += diff;
		}
		unfold(n - 1, top, bottom, left, right); //재귀 호출
	}
	
}