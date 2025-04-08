import java.io.*;
import java.util.*;

class Solution {
    static int[] parent = new int[26];
    
    public int solution(String skill, String[] skill_trees) {
        Arrays.fill(parent, Integer.MAX_VALUE);
        for (int i = 1; i < skill.length(); i++) {
            int p = skill.charAt(i - 1) - 'A';
            int c = skill.charAt(i) - 'A';
            parent[c] = p;
        }
        
        int answer = 0;
        for (String skill_tree : skill_trees) {
            if (check(skill_tree)) answer++;
        }
        return answer;
    }
    
    public boolean check(String skill_tree) {
        boolean[] canUse = new boolean[26];
        for (int i = 0; i < skill_tree.length(); i++) {
            int c = skill_tree.charAt(i) - 'A';
            int p = parent[c];
            if (p == Integer.MAX_VALUE || canUse[p]) {
                canUse[c] = true;
            } else return false;
        }
        return true;
    }
}