import java.io.*;
import java.util.*;

public class Main {
    public static int T;
    public static char[] input;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            input = br.readLine().toCharArray();
            int sum = 0;
            for (int i = 0; i < input.length; i++) {
                if (input[i] == '(') sum++;
                else {
                    if (--sum < 0) break;
                }
            }
            if (sum == 0) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}