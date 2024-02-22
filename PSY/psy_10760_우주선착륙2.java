import java.util.Scanner;

public class psy_10760_우주선착륙2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int tc = sc.nextInt();
		for (int i = 1; i <= tc; i++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[][] arr = new int[N][M];

			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					arr[r][c] = sc.nextInt();
				}
			}

			int[] dr = { -1, -1, -1, 0, 0, 1, 1, 1 };
			int[] dc = { -1, 0, 1, -1, 1, -1, 0, 1 };

			int result = 0;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					int count = 0;
					for (int d = 0; d < 8; d++) {
						int nr = r + dr[d];
						int nc = c + dc[d];
						if (nr >= 0 && nc >= 0 && nr < N && nc < M && arr[r][c] > arr[nr][nc]) {
							count++;
						}
					}
					if (count >= 4)
						result++;
				}
			}
			System.out.println("#"+i+" "+result);

		}
	}
}
