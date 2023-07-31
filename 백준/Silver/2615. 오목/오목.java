import java.io.FileInputStream;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		//////////////////////////////////////////////////////////////
		// 테스트 후 아래 파일 입력을 표준입력으로 처리하는 문장은 주석 처리해주세요!!!! ( System.setIn처리 코드 )
		//////////////////////////////////////////////////////////////
		//System.setIn(new FileInputStream("Test5.txt"));
		Scanner sc = new Scanner(System.in);
		
		int[][] board = new int[19][19]; //오목판
		//오목판 입력받기
		for (int i = 0; i < 19; i++) {
			for (int j = 0; j < 19; j++) {
				board[i][j] = sc.nextInt();
			}
		}
		
		//출력의 제한사항에 의해 아래 4방향만 확인
		int[] d1 = { -1, 0, 1, 1 };
		int[] d2 = { 1, 1, 1, 0 };
		//오목을 찾았을 때 반대 방향 확인
		int[] d3 = { 1, 0, -1, -1 };
		int[] d4 = { -1, -1, -1, 0 };
		boolean flag = false; //승부가 결정났는지를 나타내는 변수
		//오목판의 모든 칸을 방문하면서
		for (int i = 0; i < 19; i++) {
			for (int j = 0; j < 19; j++) {
				int target = board[i][j];
				if (target == 0) { //0인 경우는 지나침
					continue;
				} else { //1이나 2인 경우는 위의 4방향을 확인
					for (int d = 0; d < 4; d++) { //각 방향에 대해
						int weight = 1; //가중치
                        while (i + d1[d] * weight >= 0 && i + d1[d] * weight < 19 && j + d2[d] * weight >= 0 && j + d2[d] * weight < 19 && board[i + d1[d] * weight][j + d2[d] * weight] == target) { //가중치만큼 진행하면서 target과 같은지 비교
                            weight++;
					    }
						if (weight == 5) { //오목을 찾은 경우
                            if (i + d3[d] >= 0 && i + d3[d] < 19 && j + d4[d] >= 0 && j + d4[d] < 19) {
                                if (board[i + d3[d]][j + d4[d]] == target) { //반대 방향에 같은 색 바둑돌이 있는지 검사
								    continue; //반대 방향에 같은 색 바둑돌이 있다면 승부 결정나지 않음
							    }
                            }
							//승부가 결정난 경우 출력
							System.out.println(target);
							System.out.printf("%d %d\n", i + 1, j + 1);
							flag = true; //승부가 결정났으므로 더 이상 방문하지 않기 위해 설정
							break;
						}
					}
				}
				if (flag) { //더 이상 방문하지 않음
					break;
				}
			}
			if (flag) { //더 이상 방문하지 않음
				break;
			}
		}
		if (!flag) { //승부가 나지 않은 경우
			//출력
			System.out.println("0");
		}
	}
}

