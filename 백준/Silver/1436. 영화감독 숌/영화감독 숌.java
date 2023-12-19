import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int count = 1;
		int num = 666;
		while (N != count) {
			num++;
			if (String.valueOf(num).contains("666"))
				count++;
		}
		System.out.println(num);
		
	}

}
