import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = 3, t = 0;
        for (int i = 0; i < 3; i++) {
            String s = br.readLine();
            if (!s.equals("Fizz") && !s.equals("Buzz") && !s.equals("FizzBuzz")) {
                t = Integer.parseInt(s) + n;
                break;
            }
            n--;
        }

        if (t % 3 == 0 && t % 5 == 0) System.out.println("FizzBuzz");
        else if (t % 3 == 0) System.out.println("Fizz");
        else if (t % 5 == 0) System.out.println("Buzz");
        else System.out.println(t);
    }
}