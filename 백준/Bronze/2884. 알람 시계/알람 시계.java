import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken()) - 45;
        if (M < 0) {
            H--;
            M = 60 + M;
        }
        if (H < 0) {
            H = 23;
        }
        System.out.println(H + " " + M);
    }
}