import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            String answers = br.readLine();
            int cnt = 0, score = 0;
            for (int i = 0; i < answers.length(); i++) {
                if (answers.charAt(i) == 'X') {
                    cnt = 0;
                } else {
                    score += ++cnt;
                }
            }
            System.out.println(score);
        }
    }
}