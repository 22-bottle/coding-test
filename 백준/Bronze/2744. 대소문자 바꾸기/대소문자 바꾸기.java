import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] input = br.readLine().toCharArray();
        for (int i = 0; i < input.length; i++) {
            if (input[i] <= 90) input[i] += 32;
            else input[i] -= 32;
        }
        System.out.println(String.valueOf(input));
    }
}