import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] meetings = new int[N][];
		for (int i = 0; i < N; i++) {
			StringTokenizer st =  new StringTokenizer(br.readLine(), " ");
			meetings[i] = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
		}
		Arrays.sort(meetings, (o1, o2) -> { 
			if (o1[1] == o2[1]) {
				return o1[0] - o2[0];
			}
			return o1[1] - o2[1];
		});
		int cur_end = -1;
		int count = 0;
		for (int i = 0; i < N; i++) {
			if (meetings[i][0] >= cur_end) {
				cur_end = meetings[i][1];
				count++;
			}
		}
		System.out.println(count);
	}

}