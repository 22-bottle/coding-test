import java.io.*;
import java.util.*;

class Solution {
    static int answer = 0;
    static boolean[] selected;
    static Set<Integer> set = new HashSet<>();
    
    public void print() {
        for (boolean b : selected) {
            if (b) System.out.print("T ");
            else System.out.print("F ");
        }
        System.out.println();
    }
    
    public int solution(String[] user_id, String[] banned_id) {
        selected = new boolean[user_id.length];
        choose(user_id, banned_id, 0);
        return answer;
    }
    
    public void choose(String[] user_id, String[] banned_id, int n) {
        if (n >= banned_id.length) {
            int result = calc();
            if (!set.contains(result)) {
                answer++;
                set.add(result);
            }
            return;
        }
        for (int i = 0; i < user_id.length; i++) {
            if (selected[i]) continue;
            if (check(user_id[i], banned_id[n])) {
                selected[i] = true;
                choose(user_id, banned_id, n + 1);
                selected[i] = false;
            }
        }
    }
    
    public boolean check(String user_id, String banned_id) {
        if (user_id.length() != banned_id.length()) return false;
        for (int i = 0; i < user_id.length(); i++) {
            if (banned_id.charAt(i) != '*' && user_id.charAt(i) != banned_id.charAt(i)) return false;
        }
        return true;
    }
    
    public int calc() {
        int r = 0;
        for (int i = 0; i < selected.length; i++) {
            if (selected[i]) r = r | (1 << i);
        }
        return r;
    }
}