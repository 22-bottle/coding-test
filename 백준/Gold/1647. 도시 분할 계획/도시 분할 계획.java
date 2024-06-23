import java.io.*;
import java.util.*;

public class Main {
    static class Edge {
        int from, to, weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }

    static int N, M;
    static int[] parents;
    static Edge[] edgeList;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        edgeList = new Edge[M];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            edgeList[i] = new Edge(from, to, weight);
        }

        Arrays.sort(edgeList, (o1, o2) -> o1.weight - o2.weight);
        initSet();
        int count = 0, sum = 0, max = 0;
        for (Edge edge : edgeList) {
            if (unionSet(edge.from, edge.to)) {
                sum += edge.weight;
                max = Integer.max(max, edge.weight);
                if (++count == N - 1) break;
            }
        }
        System.out.println(sum - max);
    }

    public static void initSet() {
        parents = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parents[i] = i;
        }
    }

    public static int findRoot(int a) {
        if (a == parents[a]) return a;
        return parents[a] = findRoot(parents[a]);
    }

    public static boolean unionSet(int a, int b) {
        int aRoot = findRoot(a);
        int bRoot = findRoot(b);
        if (aRoot == bRoot) return false;
        parents[bRoot] = aRoot;
        return true;
    }
}