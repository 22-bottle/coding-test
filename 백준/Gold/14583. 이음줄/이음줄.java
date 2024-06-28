import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        double H = Double.parseDouble(st.nextToken());
        double V = Double.parseDouble(st.nextToken());
        double d = Math.sqrt(H * H + V * V);
        double a = V * (H / (H + d));
        double b = V * (d / (H + d));
        double c = Math.sqrt(a * a + H * H);
        System.out.format("%.2f %.2f", c / 2, (b * H) / c);
    }
}