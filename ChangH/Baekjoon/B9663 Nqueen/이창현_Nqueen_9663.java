package B9663;

import java.util.Scanner;

public class 이창현_Nqueen_9663 {
	static Scanner sc = new Scanner(System.in);
	static int N, Ncnt, resultcnt; // 테스트케이스의 갯수, 퀸의 갯수, 놓은 퀸 수, 결과 경우의 수
	static boolean[][] board; // 보드판

	public static void main(String[] args) {
		test(); // 테스트
	}

	private static void test() {
		testInput(); // 입력
		testProcess(); // 처리
		testOutput(); // 실행
	}

	private static void testInput() {
		N = sc.nextInt(); // N 입력
		board = new boolean[N][N]; // 보드 생성
		Ncnt = 0; // 초기화
		resultcnt = 0; // 초기화
	}

	private static void testProcess() {
		if (Ncnt >= N) {
			resultcnt++; // 퀸을 전부다 놓는것에 성공했으면 경우의 수로 추가
			return;
		}
		chess: for (int i = 0; i < N; i++) {
			if (!board[Ncnt][i]) {
				for (int j = 0; j < N; j++) { // 위로 탐색해서 퀸이 있으면 패스
					if (board[Ncnt][j]) //양옆으로
						continue chess;
					if (board[j][i]) //위아래로
						continue chess;
					if (Ncnt - j >= 0 && i - j >= 0 && board[Ncnt - j][i - j]) //대각선으로
						continue chess;
					if (Ncnt - j >= 0 && i + j < N && board[Ncnt - j][i + j]) //대각선으로
						continue chess;
				}
				// 전부 돌았는데 놓을 수 있는 위치면 퀸을 놓고 재귀
				board[Ncnt][i] = true;
				Ncnt++;
				testProcess();
				Ncnt--;
				board[Ncnt][i] = false; // 다 돌고 나왔으니 퀸을 제거하고 다른 경우의 수 탐색
			}
		}
	}

	private static void testOutput() {
		System.out.println(resultcnt);
	}
}
