import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] time = new int[n][2];
		int answer = 1;
		Stack<int[]> stack = new Stack<int[]>();
		
		for (int i = 0; i < n; i++) {
			time[i][0] = sc.nextInt();
			time[i][1] = sc.nextInt();
		}
		Arrays.sort(time, new Comparator<int[]>() { 
		    @Override
		    public int compare(int[] o1, int[] o2) {
		        return o1[1]!=o2[1] ? o1[1]-o2[1] : o1[0]-o2[0];
		    }
		});
		
		int i = 0; 
		int j = 1;

		while(i < n-1 && j < n) {
			if(time[i][1] <= time[j][0]) {
				i = j;
				j = i + 1;
				answer++;
			}
			else j++;
		}
		
		System.out.println(answer);
	}

}
