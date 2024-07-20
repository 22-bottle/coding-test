import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] len = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
            if (len[0] == 0) break;
            Arrays.sort(len);
            if (len[1] * len[1] + len[0] * len[0] == len[2] * len[2]) System.out.println("right");
            else System.out.println("wrong");
        }
    }
}