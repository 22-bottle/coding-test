import java.io.*;
import java.util.*;

public class Main {
    public static int N;
    public static char[][] starMap;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        starMap = new char[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(starMap[i], ' ');
        }
        star(0, 0, N);
        print();
    }

    public static void star(int r, int c, int n) {
        if (n == 3) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (i == 1 && j == 1) continue;
                    starMap[r + i][c + j] = '*';
                }
            }
            return;
        }
        int nextN = n / 3;
        star(r, c, nextN);
        star(r, c + nextN, nextN);
        star(r, c + nextN * 2, nextN);
        star(r + nextN, c, nextN);
        star(r + nextN, c + nextN * 2, nextN);
        star(r + nextN * 2, c, nextN);
        star(r + nextN * 2, c + nextN, nextN);
        star(r + nextN * 2, c + nextN * 2, nextN);
    }

    public static void print() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(starMap[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}