import java.io.*;
import java.util.*;

public class Main {
    public static Map<Character, Double> map = new HashMap<>();

    public static void main(String[] args) throws Exception {
        map.put('A', 4.0);
        map.put('B', 3.0);
        map.put('C', 2.0);
        map.put('D', 1.0);
        map.put('F', 0.0);
        map.put('+', 0.3);
        map.put('0', 0.0);
        map.put('-', -0.3);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] input = br.readLine().toCharArray();
        double sum = 0;
        for (int i = 0; i < input.length; i++) {
            sum += map.get(input[i]);
        }
        System.out.println(sum);
    }
}