import java.util.Scanner;

public class psy_16268_풍선팡2 {
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

			int[] dr = { -1, 1, 0, 0 };
			int[] dc = { 0, 0, -1, 1 };
			
			int max = 0;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					int sum = arr[r][c];
					for(int d = 0; d < 4; d++) {
						int nr = r+dr[d];
						int nc = c+dc[d];
						if(nr>=0 && nc>=0 && nr < N && nc < M) {
							sum += arr[nr][nc];
						}
					}
					if(max<sum)
						max = sum;
				}
			}
			System.out.println("#"+i+" "+max);
			
		}
	}
}
