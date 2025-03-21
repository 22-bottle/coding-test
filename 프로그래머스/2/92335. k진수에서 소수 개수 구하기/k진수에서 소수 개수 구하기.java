import java.io.*;
import java.util.*;

class Solution {
    public int solution(int n, int k) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.append(n % k);
            n /= k;
        }
        String[] numbers = sb.reverse().toString().split("0");
        int answer = 0;
        for (String number : numbers) {
            if (number.length() == 0) continue;
            long num = Long.parseLong(number);
            if (isPrime(num)) answer++;
        }
        return answer;
    }
    
    public boolean isPrime(long num) {
        if (num == 1) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}