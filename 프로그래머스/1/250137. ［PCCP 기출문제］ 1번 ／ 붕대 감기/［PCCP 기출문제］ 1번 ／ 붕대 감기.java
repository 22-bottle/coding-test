import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int t = 0, curH = health, cont = 0, attackIdx = 0;
        int[] curA = attacks[attackIdx];
        while (true) {
            if (curA[0] == ++t) {
                curH -= curA[1];
                if (curH <= 0) break;
                cont = 0;
                if (++attackIdx >= attacks.length) break;
                curA = attacks[attackIdx];
            } else {
                curH += bandage[1];
                if (++cont == bandage[0]) {
                    cont = 0;
                    curH += bandage[2];
                }
                if (curH > health) curH = health;
            }
        }
        return curH > 0 ? curH : -1;
    }
}