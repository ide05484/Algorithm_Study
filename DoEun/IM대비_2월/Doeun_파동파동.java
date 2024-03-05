package IM;

import java.util.Scanner;

public class 파동파동 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt(); // 테케갯수

		for (int tc = 1; tc <= T; tc++) {

			int N = sc.nextInt(); // 배열크기
			int[][] arr = new int[N][N];

			int M = sc.nextInt(); // 파동 시작값
			int R = sc.nextInt() - 1; // 파동시작R
			int C = sc.nextInt() - 1; // 파동시작C

			int D = sc.nextInt(); // 증감

			for (int i = 1; i <= N; i++) {
				// 나아갈 범위가 경계값 안일때
				// -1 +1 -2 +2 ... 범위가 이렇게 넓어지니까
				for (int r = R - i; r <= R + i; r++) {
					for (int c = C - i; c <= C + i; c++) {

						if (c >= N || c < 0 || r >= N || r < 0) { // 범위를 벗어나면
							continue;
						}

						// 범위 안이라면 0인 것만 바꿔주자
						if (arr[r][c] == 0) {
							if (M + D * i < 0) {
								arr[r][c] = 0;
								continue;
							}

							if (M + D * i > 255) {
								arr[r][c] = 255;
								continue;
							}
							arr[r][c] = M + D * i; // 증갑식을 넣어줍니도
						}
					} // 배열을 돕니다
				}
			}
			
			arr[R][C] = M;// 해당 좌표에 넝허줌.

//			for (int r = 0; r < N; r++) {
//				for (int c = 0; c < N; c++) {
//					System.out.print(arr[r][c] + " ");
//				}
//				System.out.println();
//			}
			
			System.out.print("#"+tc+ " ");

			for (int r = 0; r < N; r++) {
				int sum = 0;
				for (int c = 0; c < N; c++) {
					sum += arr[r][c];
				}
				System.out.print(sum + " ");
			}
			System.out.println();

		} // 테케마감
	}// main 마감
}
