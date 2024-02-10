import java.util.Scanner;

public class Telecom {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {

			int N = sc.nextInt(); // 배열크기
			char[][] telecom = new char[N][N]; // 텔레콤 배열

			// 입력받음
			for (int r = 0; r < N; r++) {
				String str = sc.next();
				for (int c = 0; c < N; c++) {
					telecom[r][c] = str.charAt(c);
				}
			}

			// 아래 왼쪽 위 오른쪽
			int[] dr = { 1, 0, -1, 0 };
			int[] dc = { 0, -1, 0, 1 };
			int[] dt = { 1, 2, 3 }; // 기지국 범위 (1은제외함)

			int count = 0; // H 수 세기

			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					for (int i = 0; i < 4; i++) {
						// 크기가 1인 기지국
						if (telecom[r][c] == 'A') {
							// 범위 안에서
							if (r + dr[i] >= 0 && r + dr[i] < N && c + dc[i] >= 0 && c + dc[i] < N) {
								// 그 델타배열에서 H가 있다면
								if (telecom[r + dr[i]][c + dc[i]] == 'H') {
									telecom[r + dr[i]][c + dc[i]] = 'X'; // X로 바꾸셈
								}
							}
						}
						if (telecom[r][c] == 'B') {
							for (int j = 0; j < 2; j++) {
								// 범위 안에서
								if (r + dr[i] * dt[j] >= 0 && r + dr[i] * dt[j] < N && c + dc[i] * dt[j] >= 0
										&& c + dc[i] * dt[j] < N) {
									// 그 델타배열에서 H가 있다면
									if (telecom[r + dr[i] * dt[j]][c + dc[i] * dt[j]] == 'H') {
										telecom[r + dr[i] * dt[j]][c + dc[i] * dt[j]] = 'X'; // X로 바꾸셈
									}
								}
							}
						}
						if (telecom[r][c] == 'C') {
							for (int j = 0; j <= 2; j++) {
								// 범위 안에서
								if (r + dr[i] * dt[j] >= 0 && r + dr[i] * dt[j] < N && c + dc[i] * dt[j] >= 0
										&& c + dc[i] * dt[j] < N) {
									// 그 델타배열에서 H가 있다면
									if (telecom[r + dr[i] * dt[j]][c + dc[i] * dt[j]] == 'H') {
										telecom[r + dr[i] * dt[j]][c + dc[i] * dt[j]] = 'X'; // X로 바꾸셈
									}
								}
							}
						}

					} // 델타배열돌기

				} // c마감
			} // r마감

			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if (telecom[r][c] == 'H') {
						count++;
					}
				}
			}

			System.out.println("#" + tc + " " + count);

		} // 테케마감
	}// main마감
}
