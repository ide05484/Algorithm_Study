package swea7;

import java.util.Scanner;

public class psy_13705_파동파동 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int tc = sc.nextInt();
		for (int i = 0; i < tc; i++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[][] arr = new int[N][N];
			int R = sc.nextInt() - 1;
			int C = sc.nextInt() - 1;
			int D = sc.nextInt();
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					int num = Math.max(Math.abs(R - r), Math.abs(C - c)) * D + M;
					if (num < 0)
						num = 0;
					else if (num > 255)
						num = 255;
					arr[r][c] = num;
				}
			}
			System.out.print("#" + (i + 1) + " ");
			for (int r = 0; r < N; r++) {
				int sum = 0;
				for (int c = 0; c < N; c++) {
					sum += arr[r][c];
				}
				System.out.print(sum + " ");
			}
			System.out.println();

		}
	}
}
