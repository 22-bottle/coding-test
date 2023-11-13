import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int T, R;
	static char[] input;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringBuilder sb = new StringBuilder();
			StringTokenizer st = new StringTokenizer(br.readLine());
			R = Integer.parseInt(st.nextToken());
			input = st.nextToken().toCharArray();
			for (int i = 0; i < input.length; i++) {
				for (int j = 0; j < R; j++) {
					sb.append(input[i]);
				}
			}
			System.out.println(sb);
		}
		
	}

}