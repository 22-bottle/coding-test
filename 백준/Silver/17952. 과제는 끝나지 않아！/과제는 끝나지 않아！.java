import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		
		class Task { //업무 클래스
			int score;
			int time;
			
			public Task(int score, int time) {
				super();
				this.score = score;
				this.time = time;
			}
		}
		//입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Stack<Task> s = new Stack<>();
		Task cur_task = null; //현재 하고 있는 업무
		int total_score = 0; //업무 평가 점수
		for (int i = 0; i < N; i++) { //N초에 대해
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int isTask = Integer.parseInt(st.nextToken()); //업무가 주어졌는지를 나타내는 변수
			if (isTask == 0) { //업무가 주어지지 않은 경우
				if (cur_task == null) {
					if (!s.isEmpty()) cur_task = s.pop();
					else continue;
				}
				cur_task.time--; //현재 업무를 이어서 함
				if (cur_task.time == 0) { //현재 업무가 끝난 경우
					total_score += cur_task.score; //업무 평가 점수에 반영
					if (!s.isEmpty()) cur_task = s.pop(); //밀린 업무를 가져옴
					else cur_task = null;
				}
			} else { //업무가 주어졌다면
				int score = Integer.parseInt(st.nextToken()); //주어진 업무의 점수
				int time = Integer.parseInt(st.nextToken()) - 1; //주어진 업무에 필요한 시간 (해당 업무를 바로 시작하므로 1 감소)
				if (cur_task != null) { //현재 하고 있는 업무가 있다면
					s.push(cur_task); //해당 업무를 미뤄둠
				}
				cur_task = new Task(score, time); //새로운 업무
				if (cur_task.time == 0) { //새로운 업무가 끝났다면 (필요한 시간이 1인 경우 바로 끝남)
					total_score += cur_task.score; //업무 평가 점수에 반영
					if (!s.isEmpty()) cur_task = s.pop(); //밀린 업무를 가져옴
					else cur_task = null;
				}
			}
		}
		System.out.println(total_score); //출력
	}

}