class Solution {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int boardH, boardW;
    
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        
        boardH = board.length;
        boardW = board[0].length;
        String target = board[h][w];
        for (int i = 0; i < 4; i++) {
            if (!isIn(h + dx[i], w + dy[i])) continue;
            if (board[h + dx[i]][w + dy[i]].equals(target))
                answer++;
        }
        
        return answer;
    }
    
    public boolean isIn(int h, int w) {
        if (h < 0 || h >= boardH || w < 0 || w >= boardW)
            return false;
        return true;
    }
}