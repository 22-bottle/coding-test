import java.io.*;
import java.util.*;

public class Main {
    static Map<String, Integer> map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            map = new HashMap<>();
            int n = Integer.parseInt(br.readLine());
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String name = st.nextToken();
                String type = st.nextToken();
                map.put(type, map.getOrDefault(type, 1) + 1);
            }
            int count = 1;
            for (String type : map.keySet()) {
                count *= map.get(type);
            }
            sb.append(count - 1).append("\n");
        }
        System.out.println(sb);
    }
}