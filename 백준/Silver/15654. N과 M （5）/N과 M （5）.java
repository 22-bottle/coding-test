import java.io.*;
import java.util.*;

public class Main {
    public static int N, M;
    public static int[] nums, selectedNums;
    public static boolean[] selected;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        nums = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);
        selected = new boolean[N];
        selectedNums = new int[M];
        select(0);
        System.out.println(sb);
    }

    public static void select(int n) {
        if (n == M) {
            for (int i = 0; i < M; i++) {
                sb.append(selectedNums[i]).append(' ');
            }
            sb.append('\n');
            return;
        }
        for (int i = 0; i < N; i++) {
            if (selected[i]) continue;
            selectedNums[n] = nums[i];
            selected[i] = true;
            select(n + 1);
            selected[i] = false;
        }
    }
}