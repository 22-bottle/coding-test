class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = new int[queries.length];
        for (int j = 0; j < queries.length; j++) {
            int[] query = queries[j];
            int num = Integer.MAX_VALUE;
            for (int i = query[0]; i <= query[1]; i++) {
                if (arr[i] > query[2] && arr[i] < num) {
                    num = arr[i];
                }
            }
            answer[j] = num == Integer.MAX_VALUE ? -1 : num;
        }
        return answer;
    }
}