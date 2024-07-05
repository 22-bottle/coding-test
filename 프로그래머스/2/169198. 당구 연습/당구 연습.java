import java.io.*;
import java.util.*;

class Solution {
    static int[] answer;
    
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        answer = new int[balls.length];
        Arrays.fill(answer, Integer.MAX_VALUE);
        for (int i = 0; i < balls.length; i++) {
            int[] curBall = balls[i];
            if (curBall[0] != startX || startY < curBall[1]) {
                answer[i] = Math.min(answer[i], calc(startX - curBall[0], startY + curBall[1]));
            } 
            if (curBall[0] != startX || startY > curBall[1]){
                answer[i] = Math.min(answer[i], calc(startX - curBall[0], (n * 2) - startY - curBall[1]));
            }
            if (curBall[1] != startY || startX < curBall[0]) {
                answer[i] = Math.min(answer[i], calc(startY - curBall[1], startX + curBall[0]));
            }
            if (curBall[1] != startY || startX > curBall[0]) {
                answer[i] = Math.min(answer[i], calc(startY - curBall[1], (m * 2) - startX - curBall[0]));
            }
        }
        return answer;
    }
    
    public int calc(int a, int b) {
        double da = Double.valueOf(a);
        double db = Double.valueOf(b);
        return (int)(a * a + b * b);
    }
}