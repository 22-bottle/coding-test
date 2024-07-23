import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int floor = 1, last = 1;
        while (last < N) {
            last += 6 * floor++;
        }
        System.out.println(floor);
    }
}