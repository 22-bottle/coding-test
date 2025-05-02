import java.io.*;
import java.util.*;

class Solution {
    static int X, M, R = 0, C = 0;
    static int[][] robots; //point, r, c
    static int[][] contain;

    public int solution(int[][] points, int[][] routes) {
        for (int[] point : points) {
            R = Integer.max(R, point[0]);
            C = Integer.max(C, point[1]);
        }
        X = routes.length;
        M = routes[0].length - 1;
        robots = new int[X][3];
        contain = new int[R + 1][C + 1];
        int answer = 0;
        for (int i = 0; i < X; i++) {
            int[] route = routes[i];
            int[] robot = robots[i];
            robot[0] = points[route[0] - 1][0];
            robot[1] = points[route[0] - 1][1];
            if (contain[robot[0]][robot[1]] == 1) answer++;
            contain[robot[0]][robot[1]]++;
        }

        int complete = 0;
        while (complete < X) {
            contain = new int[R + 1][C + 1];
            for (int i = 0; i < X; i++) {
                int[] robot = robots[i];
                if (robot[2] == M) continue;
                int[] route = routes[i];
                int[] target = points[route[robot[2] + 1] - 1];
                if (target[0] > robot[0]) robot[0]++;
                else if (target[0] < robot[0]) robot[0]--;
                else if (target[1] > robot[1]) robot[1]++;
                else robot[1]--;
                if (target[0] == robot[0] && target[1] == robot[1]) {
                    if (++robot[2] == M) complete++;
                }
                if (contain[robot[0]][robot[1]] == 1) answer++;
                contain[robot[0]][robot[1]]++;
            }
        }
        return answer;
    }
}