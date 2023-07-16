class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;
        
        long r1_pow = (long)r1 * r1;
        long r2_pow = (long)r2 * r2;
        for(long x = 1; x <= r2; x++) {
            long x_pow = x * x;
            long max_y = (long)Math.sqrt(r2_pow - x_pow);
            long min_y = 0;
            if(x < r1)
                min_y = (long)Math.ceil(Math.sqrt(r1_pow - x_pow));
            answer += max_y - min_y + 1;
        }
        
        return answer << 2;
    }
}