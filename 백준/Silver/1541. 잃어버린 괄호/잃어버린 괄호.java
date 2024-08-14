import java.io.*;
import java.util.*;

public class Main {
    static String formular;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        formular = br.readLine();
        String[] splitted = formular.split("-");
        List<Integer> list = new ArrayList<>();
        for (String s : splitted) {
            list.add(calc(s));
        }

        int answer = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            answer -= list.get(i);
        }
        System.out.println(answer);
    }

    public static int calc(String s) {
        List<Integer> list = new ArrayList<>();
        int f = 0;
        for (int e = 0; e < s.length(); e++) {
            if (s.charAt(e) == '+') {
                list.add(Integer.valueOf(s.substring(f, e)));
                f = e + 1;
            }
        }
        list.add(Integer.valueOf(s.substring(f, s.length())));

        int result = 0;
        for (int i = 0; i < list.size(); i++)
            result += list.get(i);
        return result;
    }
}