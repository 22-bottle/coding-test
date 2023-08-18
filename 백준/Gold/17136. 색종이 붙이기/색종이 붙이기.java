import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int leftover, answer;
	static int[][] paper;
	static int[] papers = {0, 5, 5, 5, 5, 5};

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		paper = new int[10][10];
		leftover = 0;
		answer = 26;
		for (int i = 0; i < 10; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 10; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
				if (paper[i][j] == 1) leftover++;
			}
		}
		if (leftover == 0) answer = 0;
		go(0, 0, 1);
		if (answer == 26) answer = -1;
		System.out.println(answer);
		
	}
	
	private static void go(int r, int c, int cnt) {
		if (cnt > answer) return;
		if (paper[r][c] == 0) {
			if (c == 9) go(r + 1, 0, cnt);
			else go(r, c + 1, cnt);
		} else {
			for (int size = 1; size <= 5; size++) {
				if (isValid(r, c, size)) {
					attach(r, c, size);
					if (leftover == 0 && cnt < answer) answer = cnt; 
					if (c == 9) go(r + 1, 0, cnt + 1);
					else go(r, c + 1, cnt + 1);
					detach(r, c, size);
				}
			}
		}
	}
	
	private static boolean isValid(int r, int c, int size) {
		if (papers[size] == 0) return false;
		if (leftover < size * size) return false;
		for (int i = r; i < r + size; i++) {
			for (int j = c; j < c + size; j++) {
				if (i >= 10 || j >= 10) return false;
				if (paper[i][j] == 0) return false;
			}
		}
		return true;
	}
	
	private static void attach(int r, int c, int size) {
		for (int i = r; i < r + size; i++) {
			for (int j = c; j < c + size; j++) {
				paper[i][j] = 0;
			}
		}
		papers[size]--;
		leftover -= size * size;
	}
	
	private static void detach(int r, int c, int size) {
		for (int i = r; i < r + size; i++) {
			for (int j = c; j < c + size; j++) {
				paper[i][j] = 1;
			}
		}
		papers[size]++;
		leftover += size * size;
	}

}