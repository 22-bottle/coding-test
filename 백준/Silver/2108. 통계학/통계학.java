import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        int[] count = new int[8001];

        int sum = 0, min = 4001, max = -4001, cnt = 0;
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(br.readLine());
            sum += nums[i];
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
            cnt = Math.max(cnt, ++count[nums[i] + 4000]);
        }
        int freq = Integer.MAX_VALUE;
        for (int i = 0; i <= 8000; i++) {
            if (count[i] == cnt) {
                if (freq == Integer.MAX_VALUE) freq = i - 4000;
                else {
                    freq = i - 4000;
                    break;
                }
            }
        }
        Arrays.sort(nums);

        System.out.println(Math.round((float)sum / N));
        System.out.println(nums[N / 2]);
        System.out.println(freq);
        System.out.println(max - min);
    }
}