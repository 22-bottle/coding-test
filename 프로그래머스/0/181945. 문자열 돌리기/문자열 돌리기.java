import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] str = br.readLine().toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char c : str) {
            sb.append(c).append('\n');
        }
        System.out.println(sb.toString());
    }
}