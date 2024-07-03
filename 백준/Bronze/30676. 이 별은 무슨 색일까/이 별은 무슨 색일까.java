import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int gamma = Integer.parseInt(br.readLine());
        if (gamma >= 620) System.out.println("Red");
        else if (gamma >= 590) System.out.println("Orange");
        else if (gamma >= 570) System.out.println("Yellow");
        else if (gamma >= 495) System.out.println("Green");
        else if (gamma >= 450) System.out.println("Blue");
        else if (gamma >= 425) System.out.println("Indigo");
        else System.out.println("Violet");
    }
}