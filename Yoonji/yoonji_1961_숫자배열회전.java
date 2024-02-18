import java.util.Scanner;

public class 숫자배열회전_1961 {
	
	static int N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 테스트 케이스 수 입력받기
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {

			N = sc.nextInt();

			int[][] arr = new int[N][N];
			int[][] arr90 =  new int[N][N];
			int[][] arr180 =  new int[N][N];
			int[][] arr270 =  new int[N][N];

			// 입력받기
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					arr[r][c] = sc.nextInt();
				}
			}
			
			// 회전하고 배열 저장
			arr90 = rotate(arr);
			arr180 = rotate(arr90);
			arr270 = rotate(arr180);
			
			// 출력을 위해 회전 배열을 합친 배열을 선언
			int[][] rotatedArr = new int [N][N * 3];
			// 90도
			for(int r = 0; r < N; r++) {
				for(int c = 0; c < N; c++) {
					rotatedArr[r][c] = arr90[r][c];
				}
			}
			// 180도
			for(int r = 0; r < N; r++) {
				for(int c = N; c < N * 2; c++) {
					rotatedArr[r][c] = arr180[r][c - N];
				}
			}
			// 270도를 합친 배열에 넣어줌
			for(int r = 0; r < N; r++) {
				for(int c = N * 2; c < N * 3; c++) {
					rotatedArr[r][c] = arr270[r][c - N * 2];
				}
			}
			
			// 요구사항에 맞게 출력
			System.out.println("#" + tc);
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N * 3; c++) {
					System.out.print(rotatedArr[r][c]);
					if(c % N == N - 1) {
						System.out.print(" ");
					}
				}
				System.out.println();
			}


		
		} // tc 반복문 종료
	} // main 종료
	
	// 90도 회전 함수
	static int[][] rotate(int[][] arr){
		int[][] rotatedArr = new int[N][N];
		
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < N ; c++) {
				rotatedArr[r][c] = arr[N - 1 - c][r];
			}
		}
		
		return rotatedArr;
	}
}
