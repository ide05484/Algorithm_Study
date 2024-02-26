import java.util.Scanner;

public class 풍선팡_16268 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
			
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			// 배열 입력 받기
			int[][] arr = new int [N][M];
			for(int r = 0; r < N; r++) {
				for(int c = 0; c < M; c++) {
					arr[r][c] = sc.nextInt();
				}
			}
			
			int max = 0;
			for(int r = 0; r < N; r++) {
				for(int c = 0; c < M; c++) {
					// 본인 자리와
					int sum = arr[r][c];
					// 상하좌우의 합계를 구할 것
					int[] dr = {-1, 1, 0, 0};
					int[] dc = {0, 0, -1, 1};
					// 델타배열 순회
					for(int d = 0; d < 4; d++) {
						int nr = r + dr[d];
						int nc = c + dc[d];
						// 제약조건 확인
						if(nr >= 0 && nr < N && nc >= 0 & nc < M) {
							sum += arr[nr][nc];
						}
					}
					// 최대값 갱신
					if(max < sum) {
						max = sum;
					}
					
				}
			}
			//양식에 맞추어 출력
			System.out.println("#" + tc + " " + max);
			
		}

	}

}
