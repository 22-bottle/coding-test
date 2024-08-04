import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            String[] command = br.readLine().split(" ");
            if (command[0].equals("add")) {
                set.add(Integer.parseInt(command[1]));
            } else if (command[0].equals("remove")) {
                set.remove(Integer.parseInt(command[1]));
            } else if (command[0].equals("check")) {
                if (set.contains(Integer.parseInt(command[1]))) sb.append(1).append("\n");
                else sb.append(0).append("\n");
            } else if (command[0].equals("toggle")) {
                if (set.contains(Integer.parseInt(command[1]))) set.remove(Integer.parseInt(command[1]));
                else set.add(Integer.parseInt(command[1]));
            } else if (command[0].equals("all")) {
                for (int j = 1; j <= 20; j++)
                    set.add(j);
            } else if (command[0].equals("empty")) {
                for (int j = 1; j <= 20; j++)
                    set.remove(j);
            }
        }
        System.out.println(sb);
    }
}