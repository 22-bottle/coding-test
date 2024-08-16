import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static List<int[]> list = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list.add(new int[] {i, Integer.parseInt(st.nextToken()), 0});
        }

        Collections.sort(list, (o1, o2) -> o1[1] - o2[1]);
        int count = -1, cur = Integer.MIN_VALUE;
        for (int[] l : list) {
            if (l[1] == cur) l[2] = count;
            else l[2] = ++count;
            cur = l[1];
        }

        Collections.sort(list, (o1, o2) -> o1[0] - o2[0]);
        StringBuilder sb = new StringBuilder();
        for (int[] l : list)
            sb.append(l[2]).append(" ");
        System.out.println(sb);
    }
}