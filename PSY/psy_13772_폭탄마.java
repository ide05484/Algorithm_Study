package swea7;

import java.util.Scanner;

public class psy_13772_폭탄마 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int tc = sc.nextInt();
		for (int i = 0; i < tc; i++) {
			int N = sc.nextInt();
			int P = sc.nextInt();
			int[][] arr = new int[N][N];
			int[] dc1 = { -1, 0, 1, 0 };
			int[] dr1 = { 0, -1, 0, 1 };
			int[] dc2 = { -1, -1, 1, 1 };
			int[] dr2 = { 1, -1, 1, -1 };

			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					arr[r][c] = sc.nextInt();
				}
			}
			int max = 0;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					int sum1 = arr[r][c];
					int sum2 = sum1;
					for (int d = 0; d < 4; d++) {
						for (int l = 1; l <= P; l++) {
							int nr = r + dr1[d] * l;
							int nc = c + dc1[d] * l;
							if (nr >= 0 && nc >= 0 && nr < N && nc < N)
								sum1 += arr[nr][nc];
							nr = r + dr2[d] * l;
							nc = c + dc2[d] * l;
							if (nr >= 0 && nc >= 0 && nr < N && nc < N)
								sum2 += arr[nr][nc];
						}
					}
					sum1 = Math.max(sum1, sum2);
					if (max < sum1)
						max = sum1;
				}
			}

			System.out.print("#" + (i + 1) + " ");
			System.out.print(max);
			System.out.println();

		}
	}
}
