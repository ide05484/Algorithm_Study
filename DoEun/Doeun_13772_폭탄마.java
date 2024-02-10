import java.util.Scanner;

public class Boomer {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {

			int N = sc.nextInt(); // 배열크기
			int[][] bomb = new int[N][N]; // 폭탄배열

			int P = sc.nextInt(); // 폭탄 파워

			// 입력받음
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					bomb[r][c] = sc.nextInt();
				}
			}

			// 아래 왼쪽 위 오른쪽 오른아래 왼아래 오른위 왼위
			int[] dr = { 1, 0, -1, 0, 1, 1, -1, -1 };
			int[] dc = { 0, -1, 0, 1, 1, -1, 1, -1 };

			int happy = 0; // H 수 세기

			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					int sum1 = 0; // 가로세로
					int sum2 = 0; // 대각선
					for (int i = 0; i < 4; i++) {
						for (int p = 0; p <= P; p++) {
							// 범위 안에서 (십자)
							if (r + dr[i] * p >= 0 && r + dr[i] * p < N && c + dc[i] * p >= 0 && c + dc[i] * p < N) {
								sum1 += bomb[r + dr[i] * p][c + dc[i] * p];
							}
							// 대각선 범위안에서
							if (r + dr[i + 4] * p >= 0 && r + dr[i + 4] * p < N && c + dc[i + 4] * p >= 0
									&& c + dc[i + 4] * p < N) {
								sum2 += bomb[r + dr[i + 4] * p][c + dc[i + 4] * p];
							}
						} // 폭탄범위만큼
					} // 델다를 돌고있음
					sum1 = sum1 - 3 * bomb[r][c]; // 본인에 해당하는 좌표 3번 뺴줘야함
					sum2 = sum2 - 3 * bomb[r][c];

					happy = Math.max(happy, Math.max(sum1, sum2)); // 둘 중 더 최대를 또 최대로 갱신
				} // c마감
			} // r마감

			System.out.println("#" + tc + " " + happy);

		} // 테케마감
	}// main마감
}
