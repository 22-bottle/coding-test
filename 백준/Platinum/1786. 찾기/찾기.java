import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	
	static char[] T, P;
	static List<Integer> answer = new ArrayList<>();
	static int[] pi;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = br.readLine().toCharArray();
		P = br.readLine().toCharArray();
		
		pi = new int[P.length];
		for (int i = 1, j = 0; i < P.length; i++) {
			while (j > 0 && P[i] != P[j]) {
				j = pi[j - 1];
			}
			if (P[i] == P[j]) {
				pi[i] = ++j;
			}
		}
		
		for (int i = 0, j = 0; i < T.length; i++) {
			while (j > 0 && T[i] != P[j]) {
				j = pi[j - 1];
			}
			if (T[i] == P[j]) {
				if (j == P.length - 1) {
					answer.add(i - P.length + 2);
					j = pi[j];
				} else {
					j++;
				}
			}
		}
		
		System.out.println(answer.size());
		for (Integer i : answer) System.out.print(i + " ");
		
	}

}
