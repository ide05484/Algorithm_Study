import java.util.Scanner;

public class 우주선착륙_10760 {

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
			// 착륙 가능한 예비후보지 check 구하기
			int check = 0;
			for(int r = 0; r < N; r++) {
				for(int c = 0; c < M; c++) {
					int count = 0;
					
					// 8방향
					int[] dr = {-1, 1, 0, 0, -1, -1, 1, 1};
					int[] dc = {0, 0, -1, 1, -1, 1, -1, 1};
					// 델타배열 순회
					for(int d = 0; d < 8; d++) {
						int nr = r + dr[d];
						int nc = c + dc[d];
						// 제약조건 확인
						if(nr >= 0 && nr < N && nc >= 0 & nc < M) {
							// 착륙 가능한 지점 수 카운트
							if(arr[r][c] > arr[nr][nc]) {
								count++;
							}
						}
					}
					// 착륙 가능 지점 수가 4 이상이라면 예비후보지++
					if(count >= 4) {
						check++;
					}
					
				}
			}
			//양식에 맞추어 출력
			System.out.println("#" + tc + " " + check);
			
		}

	}

}