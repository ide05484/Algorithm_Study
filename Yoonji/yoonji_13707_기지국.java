import java.util.Scanner;

public class 기지국_13707 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {

			int N = sc.nextInt();
			sc.nextLine();

			int[][] arr = new int[N][N];
			// 숫자 배열로 저장
			for (int r = 0; r < N; r++) {
				String temp = sc.nextLine();
				for(int c = 0; c < N; c++) {		
					if (temp.charAt(c) == 'A') {
						arr[r][c] = 1;
					} else if (temp.charAt(c) == 'B') {
						arr[r][c] = 2;
					} else if (temp.charAt(c) == 'C') {
						arr[r][c] = 3;
					} else if (temp.charAt(c) == 'H') {
						arr[r][c] = -1;
					} else {
						arr[r][c] = 0;
					}
				}
			}
			// 상하좌우
			int[] dr = { -1, 1, 0, 0 };
			int[] dc = { 0, 0, -1, 1 };

			for (int r = 0; r < N; r++) {
				for(int c = 0; c < N; c++) {
					
					for(int d = 0; d < 4; d++) {
						for(int p = 1; p <= arr[r][c]; p++) {
							// 기지국 범위 안에 들어오면
							int nr = r + dr[d] * p;
							int nc = c + dc[d] * p;
							// 제약조건 확인 후
							if(nr >= 0 && nr < N && nc >= 0 && nc < N) {
							// 집이면 0으로 바꾸게 함
								if(arr[nr][nc] == -1) {
									arr[nr][nc] = 0;
								}
							}
						}
					}
				}
			}
			// 집 개수 세기
			int count = 0;
			for (int r = 0; r < N; r++) {
				for(int c = 0; c < N; c++) {
					if(arr[r][c] == -1) {
						count++;
					}
				}
			}
			System.out.printf("#%d %d\n", tc, count);
		}
	}
}
