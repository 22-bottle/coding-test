import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int[] cnt = new int[26];
		for (int i = 0; i < str.length(); i++) {
			char alphabet = str.charAt(i);
			if (alphabet <= 'Z') 
				cnt[alphabet - 'A']++;
			else cnt[alphabet - 'a']++;
		}
		
		int maxV = 0;
		int maxI = -1;
		boolean many = false;
		for (int i = 0; i < 26; i++) {
			if (cnt[i] > maxV) {
				maxV = cnt[i];
				maxI = i;
				many = false;
			} else if (cnt[i] == maxV)
				many = true;
		}
		if (many) System.out.println('?');
		else System.out.println((char)(maxI + 'A'));
		
	}

}