import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] str1 = br.readLine().toCharArray();
		char[] str2 = br.readLine().toCharArray();
		int[][] mem = new int[str1.length + 1][str2.length + 1];
		for (int i = 1; i <= str1.length; i++) {
			for (int j = 1; j <= str2.length; j++) {
				if (str1[i - 1] == str2[j - 1]) {
					mem[i][j] = mem[i - 1][j - 1] + 1;
				} else {
					mem[i][j] = Integer.max(mem[i - 1][j], mem[i][j - 1]);
				}
			}
		}
		System.out.println(mem[str1.length][str2.length]);
		
	}

}