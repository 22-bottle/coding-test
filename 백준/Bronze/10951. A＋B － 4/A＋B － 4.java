import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			String str = br.readLine();
			if (str == null || str.equals("")) break;
			
			System.out.println(Integer.parseInt(str.substring(0, 1)) + Integer.parseInt(str.substring(2)));
		}
		
	}

}
