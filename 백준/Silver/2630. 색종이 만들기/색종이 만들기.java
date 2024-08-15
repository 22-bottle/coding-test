import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] paper;
    static int[] count = new int[2];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        paper = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        cut(0, 0, N);
        System.out.println(count[0]);
        System.out.println(count[1]);
    }

    public static void cut(int r, int c, int n) {
        int color = paper[r][c];
        boolean cut = false;
        for (int i = r; i < r + n; i++) {
            for (int j = c; j < c + n; j++) {
                if (paper[i][j] != color) {
                    cut = true;
                    break;
                }
            }
        }
        if (!cut) {
            count[color]++;
            return;
        }
        int half = n / 2;
        cut(r, c, half);
        cut(r + half, c, half);
        cut(r, c + half, half);
        cut(r + half, c + half, half);
    }
}