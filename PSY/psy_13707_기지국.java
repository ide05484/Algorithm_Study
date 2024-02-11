package swea5;

import java.util.Scanner;

public class psy_13707_기지국 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int tc = sc.nextInt();
		for (int i = 0; i < tc; i++) {
			int N = sc.nextInt();
			int[][] arr = new int[N][N];
			for (int r = 0; r < N; r++) {
				String str = sc.next();
				for (int c = 0; c < N; c++) {
					char cha = str.charAt(c);
					int num = 0;
					if (cha == 'A')
						num = 1;
					else if (cha == 'B')
						num = 2;
					else if (cha == 'C')
						num = 3;
					else if (cha == 'H')
						num = -1;
					arr[r][c] = num;
				}
			}
			int[] dr = { -1, 0, 1, 0 };
			int[] dc = { 0, 1, 0, -1 };
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if (arr[r][c] > 0) {
						for (int d = 0; d < 4; d++) {
							for (int l = 1; l <= arr[r][c]; l++) {
								int nr = r + dr[d] * l;
								int nc = c + dc[d] * l;

								if (nr >= 0 && nc >= 0 && nr < N && nc < N && arr[nr][nc] == -1)
									arr[nr][nc] = 0;

							}
						}
						arr[r][c] = 0;
					}
				}
			}
			int sum = 0;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					sum += arr[r][c];
				}
			}
			
			System.out.println("#"+(i+1)+" "+(-1 * sum));

		}
	}
}