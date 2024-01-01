import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, score[][], mem1[], mem2[];
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		score = new int[N][3];
		mem1 = new int[3];
		mem2 = new int[3];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				score[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < 3; i++) {
			mem1[i] = mem2[i] = score[0][i];
		}
		for (int i = 1; i < N; i++) {
			int max1 = mem1[0], max2 = mem1[2];
			mem1[0] = Integer.max(mem1[0], mem1[1]) + score[i][0];
			mem1[2] = Integer.max(mem1[1], mem1[2]) + score[i][2];
			mem1[1] = Integer.max(max1, Integer.max(mem1[1], max2)) + score[i][1];
			int min1 = mem2[0], min2 = mem2[2];
			mem2[0] = Integer.min(mem2[0], mem2[1]) + score[i][0];
			mem2[2] = Integer.min(mem2[1], mem2[2]) + score[i][2];
			mem2[1] = Integer.min(min1, Integer.min(mem2[1], min2)) + score[i][1];
		}
		System.out.println(Integer.max(mem1[0], Integer.max(mem1[1], mem1[2])) + " " + Integer.min(mem2[0], Integer.min(mem2[1], mem2[2])));
		
	}

}