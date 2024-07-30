class Solution {
    public String[] solution(String[] picture, int k) {
        char[][] newPic = new char[picture.length * k][picture[0].length() * k];
        for (int i = 0; i < picture.length; i++) {
            String line = picture[i];
            for (int j = 0; j < line.length(); j++) {
                for (int a = 0; a < k; a++) {
                    for (int b = 0; b < k; b++) {
                        newPic[i * k + a][j * k + b] = line.charAt(j);
                    }
                }
            }
        }
        
        String[] answer = new String[newPic.length];
        for (int i = 0; i < newPic.length; i++) {
            String line = "";
            for (int j = 0; j < newPic[0].length; j++) {
                line += newPic[i][j];
            }
            answer[i] = line;
        }
        return answer;
    }
}