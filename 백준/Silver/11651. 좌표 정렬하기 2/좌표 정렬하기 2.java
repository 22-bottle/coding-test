import java.io.*;
import java.util.*;

public class Main {
    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static PriorityQueue<Point> pq = new PriorityQueue<>((o1, o2) -> {
        if (o1.y == o2.y) return o1.x - o2.x;
        return o1.y - o2.y;
    });

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            pq.add(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            Point point = pq.poll();
            sb.append(point.x).append(" ").append(point.y).append("\n");
        }
        System.out.println(sb);
    }
}