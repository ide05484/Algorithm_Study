import java.util.Scanner;

public class yoonji_13772_폭탄마 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
			
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			// 배열 선언 후 값 입력
			int[][] arr = new int [N][N];
			
			for(int r = 0; r < N; r++) {
				for(int c = 0; c < N; c++) {
					arr[r][c] = sc.nextInt();
				}
			}
			// 텔타 배열
			int[] dr = { -1, 1, 0, 0, -1, -1, 1, 1};
			int[] dc = { 0, 0, -1, 1, -1, 1, -1, 1};
			
			int crossMax = 0;
			int xMax = 0;
			
			// +, x에서 최대값 구해주기
			for(int r = 0; r < N; r++) {
				for(int c = 0; c < N; c++) {
					// 현재 위치 기준으로 범위 늘어나는 만큼 더해줄 것
					int crossSum = arr[r][c];
					int xSum = arr[r][c];
					// + 범위
					for(int d = 0; d < 4; d++) {
						for(int p = 1; p <= M; p++) {
							// power 만큼 범위 증가
							int nr = r + dr[d] * p; 
							int nc = c + dc[d] * p;
							
							// 배열 범위 내인지 검시
							if(nc >= 0 && nc < N && nr >= 0 && nr < N) {
								crossSum += arr[nr][nc];
							}
						}

					}
					crossMax = Math.max(crossMax, crossSum);
					// x 범위
					for(int d = 4; d < 8; d++) {
						for(int p = 1; p <= M; p++) {
							// power 만큼 범위 증가
							int nr = r + dr[d] * p; 
							int nc = c + dc[d] * p;
							
							// 배열 범위 내인지 검시
							if(nc >= 0 && nc < N && nr >= 0 && nr < N) {
								xSum += arr[nr][nc];
							}
						}

					}
					xMax = Math.max(xMax, xSum);					
				}
				
			}
			
			System.out.printf("#%d %d\n", tc, Math.max(crossMax, xMax));
			
			
		}
	}

}
