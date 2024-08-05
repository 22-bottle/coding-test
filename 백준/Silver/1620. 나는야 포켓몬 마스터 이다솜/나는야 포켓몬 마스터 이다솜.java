import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        String[] names = new String[N + 1];
        Map<String, Integer> map = new HashMap<>();

        for (int i = 1; i <= N; i++) {
            String name = br.readLine();
            names[i] = name;
            map.put(name, i);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            String command = br.readLine();
            if (Character.isDigit(command.charAt(0)))
                sb.append(names[Integer.parseInt(command)]).append("\n");
            else sb.append(map.get(command)).append("\n");
        }
        System.out.println(sb);
    }
}