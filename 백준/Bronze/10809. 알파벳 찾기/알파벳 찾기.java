import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        int[] location = new int[26];
        Arrays.fill(location, -1);
        for (int i = 0; i < S.length(); i++) {
            if (location[S.charAt(i) - 'a'] == -1) {
                location[S.charAt(i) - 'a'] = i;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            sb.append(location[i]).append(' ');
        }
        System.out.println(sb.toString());
    }
}