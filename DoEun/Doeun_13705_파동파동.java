import java.util.Scanner;

public class Wave {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {

			int N = sc.nextInt(); // 배열크기
			int[][] water = new int[N][N]; // 파동배열

			int M = sc.nextInt(); // 파동 시작값
			int R = sc.nextInt(); // 파동 시작 좌표 행
			int C = sc.nextInt(); // 파동 시작 좌표 열

			water[R][C] = M;

			int D = sc.nextInt(); // 증감값

			// 아래 왼쪽 위 오른쪽 오른아래 왼아래 오른위 왼위
			int[] dr = { 1, 0, -1, 0, 1, 1, -1, -1 };
			int[] dc = { 0, -1, 0, 1, 1, -1, 1, -1 };

			// 계속 증가한다면? 배열을 다 채울때까지
			if (D >= 0) {
				for (int j = 0; j < 8; j++) {
					// 새 좌표가 범위 안에 있으면
					while (water[R][C] >= 0 && water[R][C] < N) {
						// 모든 델타에서
						for (int i = 0; i < 8; i++) {
							// 이 범위 안에서
							if (water[R + dr[i]][C + dc[i]] != 0) { // 0이 아닌 것에만
								water[R + dr[i]][C + dr[i]] = M + D; // 해당 좌표에 전부 M+D를 넣어두고
							}
							// 좌표 재설정
							R = R + dr[i];
							C = C + dc[i];
						} // 모든 델타를 돔
						M = water[R][C]; // M에 새 좌표 값을 넣어둠
					}
				}
			}

			if (D < 0) {
				// 새 좌표가 범위 안에 있으면
				for (int j = 0; j < 8; j++) {
					while (water[R][C] >= 0 && water[R][C] < N) { // 마이너스가 0보다 클때까지만
						// 모든 델타에서
						for (int i = 0; i < 8; i++) {
							// 이 범위 안에서
							if (water[R + dr[i]][C + dc[i]] != 0) { // 0이 아닌 것에만
								water[R + dr[i]][C + dr[i]] = M + D; // 해당 좌표에 전부 M+D를 넣어두고
							}
						} // 모든 델타를 돔
							// 좌표 재설정
						R = R + dr[j];
						C = C + dc[j];
					}
					M = water[R][C]; // M에 새 좌표 값을 넣어둠
				} // 다시 그 8방향...에서... 보는거임!!!!!!!??
			}

			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					System.out.print(water[r][c]);
				}
				System.out.println();
			}

			System.out.print("#" + tc + " ");

			int sum = 0;
			// sum 출력
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					sum += water[r][c]; // 해당 행의 열을 다 더해주셈
				}
				System.out.print(sum + " ");
			}
		} // 테케마감
	}// main마감
}
