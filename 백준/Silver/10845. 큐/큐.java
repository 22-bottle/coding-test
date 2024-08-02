import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if (command.equals("push")) {
                q.offer(Integer.parseInt(st.nextToken()));
            } else if (command.equals("pop")) {
                if (q.isEmpty()) sb.append(-1).append("\n");
                else sb.append(q.poll()).append("\n");
            } else if (command.equals("size")) {
                sb.append(q.size()).append("\n");
            } else if (command.equals("empty")) {
                if (q.isEmpty()) sb.append(1).append("\n");
                else sb.append(0).append("\n");
            } else if (command.equals("front")) {
                if (q.isEmpty()) sb.append(-1).append("\n");
                else sb.append(q.peek()).append("\n");
            } else if (command.equals("back")) {
                if (q.isEmpty()) {
                    sb.append(-1).append("\n");
                    continue;
                }
                int size = q.size();
                for (int j = 0; j < size - 1; j++) {
                    q.offer(q.poll());
                }
                sb.append(q.peek()).append("\n");
                q.offer(q.poll());
            }
        }
        System.out.println(sb);
    }
}