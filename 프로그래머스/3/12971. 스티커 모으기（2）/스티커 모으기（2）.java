import java.io.*;
import java.util.*;

class Solution {
    static int[][] mem1, mem2;
    
    public int solution(int sticker[]) {
        mem1 = new int[sticker.length][2]; //마지막 선택 안하는 경우
        mem1[0][1] = sticker[0];
        for (int i = 1; i < mem1.length - 1; i++) {
            mem1[i][0] = Integer.max(mem1[i - 1][0], mem1[i - 1][1]);
            mem1[i][1] = mem1[i - 1][0] + sticker[i];
        }
        int answer1 = mem1.length > 1 ? Integer.max(mem1[mem1.length - 2][0], mem1[mem1.length - 2][1]) : sticker[0];
        
        mem2 = new int[sticker.length][2]; //1번째 선택 안하는 경우
        if (sticker.length > 1) mem2[1][1] = sticker[1];
        for (int i = 2; i < mem2.length; i++) {
            mem2[i][0] = Integer.max(mem2[i - 1][0], mem2[i - 1][1]);
            mem2[i][1] = mem2[i - 1][0] + sticker[i];
        }
        int answer2 = Integer.max(mem2[mem2.length - 1][0], mem2[mem2.length - 1][1]);
        return Integer.max(answer1, answer2);
    }
}