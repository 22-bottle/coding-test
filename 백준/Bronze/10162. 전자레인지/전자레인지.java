import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		//입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		if (T % 10 != 0) { //T가 10의 배수가 아닌 경우 T초를 맞출 수 없음
			System.out.println(-1); //출력
		} else { //T가 10의 배수인 경우 T초를 맞출 수 있음
			int A = T / 300; //300초(5분)을 누르는 횟수
			T %= 300;
			int B = T / 60; //60초(1분)을 누르는 횟수
			T %= 60;
			int C = T / 10; //10초를 누르는 횟수
			System.out.println(A + " " + B + " " + C); //출력
		}
	}

}