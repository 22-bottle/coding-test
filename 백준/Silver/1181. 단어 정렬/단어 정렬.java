import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	
	static int N;
	static List<String>[] strings = new ArrayList[51];

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		for (int i = 1; i <= 50; i++) {
			strings[i] = new ArrayList<String>();
		}
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			strings[str.length()].add(str);
		}
		for (int i = 1; i <= 50; i++) {
			Collections.sort(strings[i]);
			String old = "";
			for (String s : strings[i]) {
				if (old.equals(s)) continue;
				old = s;
				System.out.println(s);
			}
		}
		
	}

}
