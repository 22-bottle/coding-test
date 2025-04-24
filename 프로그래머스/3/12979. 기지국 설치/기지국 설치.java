import java.io.*;
import java.util.*;

class Solution {
    static int apt = 1, stn = 0;
    
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        while (apt <= n) {
            int station = stn < stations.length ? stations[stn] : n + 1 + w;
            int left = station - w;
            int right = station + w;
            if (apt < left) {
                apt += w + w + 1;
                answer++;
            } else if (apt > right) {
                stn++;
            } else {
                apt = right + 1;
            }
        }
        return answer;
    }
}