import java.io.*;
import java.util.*;

public class Main {
    static boolean[] check = new boolean[31];
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 28; i++) {
            check[Integer.parseInt(br.readLine())] = true;
        }
        for (int i = 1; i <= 30; i++) {
            if (!check[i]) System.out.println(i);
        }
    }
}