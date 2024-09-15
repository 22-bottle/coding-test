class Solution {
    static int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};
    
    public int solution(int[][] board) {
        int answer = board.length * board[0].length;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 1) {
                    answer--;
                    for (int d = 0; d < 8; d++) {
                        int r = i + dr[d];
                        int c = j + dc[d];
                        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length) continue;
                        if (board[r][c] == 0) {
                            answer--;
                            board[r][c] = -1;
                        }
                    }
                }
            }
        }
        return answer;
    }
}