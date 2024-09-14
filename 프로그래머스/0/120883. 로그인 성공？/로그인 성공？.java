class Solution {
    public String solution(String[] id_pw, String[][] db) {
        for (String[] mem : db) {
            if (mem[0].equals(id_pw[0])) {
                if (mem[1].equals(id_pw[1])) return "login";
                else return "wrong pw";
            }
        }
        return "fail";
    }
}