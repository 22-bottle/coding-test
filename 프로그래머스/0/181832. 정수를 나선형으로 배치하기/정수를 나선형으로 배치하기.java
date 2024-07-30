class Solution {
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    static int[][] answer;
    
    public int[][] solution(int n) {
        answer = new int[n][n];
        int num = 1, r = 0, c = 0, d = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                answer[r][c] = num++;
                if (!canMove(r + dr[d], c + dc[d])) {
                    d = (d + 1) % 4;
                }
                r += dr[d];
                c += dc[d];
            }
        }
        return answer;
    }
    
    public boolean canMove(int r, int c) {
        if (r < 0 || c < 0 || r >= answer.length || c >= answer.length) return false;
        return answer[r][c] == 0;
    }
}