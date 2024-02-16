package swea9;

import java.util.Scanner;

public class psy_1961_숫자배열회전{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int tc = sc.nextInt();
		for (int i = 1; i <= tc; i++) {
			int N = sc.nextInt();
			int[][] arr = new int[N][N];

			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					arr[r][c] = sc.nextInt();
				}
			}

			int[][] result = new int[N][N * 3 + 2];

			for (int r = 0; r < N; r++) {
				for (int c = 0; c < result[r].length; c++) {
					int[][] arr1 = spin(arr, N);
					int[][] arr2 = spin(arr1, N);
					int[][] arr3 = spin(arr2, N);
					if (c <= N - 1) {
						result[r][c] = arr1[r][c];
					} else if (c == N || c == 2 * N + 1) {
						result[r][c] = -1;
					} else if (c > N && c < 2 * N + 1) {
						result[r][c] = arr2[r][c - N - 1];
					} else
						result[r][c] = arr3[r][c - 2 * N - 2];
				}
			}
			System.out.print("#"+i+"\n");
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < result[r].length; c++) {
					if (result[r][c] == -1)
						System.out.print(" ");
					else
						System.out.print(result[r][c]);
				}
				System.out.println();
			}

		}
	}

	static int[][] spin(int[][] arr, int N) {
		int[][] arrSpin = new int[N][N];
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				arrSpin[r][c] = arr[N - c - 1][r];
			}
		}

		return arrSpin;
	}
}
