import java.io.*;
import java.util.*;

class Solution {
    PriorityQueue<String> pq1 = new PriorityQueue<>();
    PriorityQueue<String> pq2 = new PriorityQueue<>();
    List<String> list1 = new ArrayList<>();
    List<String> list2 = new ArrayList<>();
    
    public int solution(String str1, String str2) {
        for (int i = 0; i < str1.length() - 1; i++) {
            if (check(str1.charAt(i)) || check(str1.charAt(i + 1))) continue;
            pq1.add(str1.substring(i, i + 2).toLowerCase());
        }
        for (int i = 0; i < str2.length() - 1; i++) {
            if (check(str2.charAt(i)) || check(str2.charAt(i + 1))) continue;
            pq2.add(str2.substring(i, i + 2).toLowerCase());
        }
        while (!pq1.isEmpty()) {
            list1.add(pq1.poll());
        }
        while (!pq2.isEmpty()) {
            list2.add(pq2.poll());
        }
        int union = union();
        int intersect = intersect();
        if (union == 0) return 65536;
        return (int)((double)intersect / union * 65536);
    }
    
    public int union() {
        if (list1.isEmpty() && list2.isEmpty()) return 0;
        int count = 0, idx1 = 0, idx2 = 0;
        while (idx1 < list1.size() && idx2 < list2.size()) {
            String s1 = list1.get(idx1);
            String s2 = list2.get(idx2);
            if (s1.compareTo(s2) > 0) {
                idx2++;
            } else if (s1.compareTo(s2) < 0) {
                idx1++;
            } else {
                idx1++; idx2++;
            }
            count++;
        }
        count += list1.size() - idx1;
        count += list2.size() - idx2;
        return count;
    }
    
    public int intersect() {
        if (list1.isEmpty() || list2.isEmpty()) return 0;
        int count = 0, idx1 = 0, idx2 = 0;
        while (idx1 < list1.size() && idx2 < list2.size()) {
            String s1 = list1.get(idx1);
            String s2 = list2.get(idx2);
            if (s1.compareTo(s2) > 0) {
                idx2++;
            } else if (s1.compareTo(s2) < 0) {
                idx1++;
            } else {
                idx1++; idx2++;
                count++;
            }
        }
        return count;
    }
    
    public boolean check(char c) {
        if (c < 'A' || c > 'z' || (c > 'Z' && c < 'a')) return true;
        return false;
    }
}