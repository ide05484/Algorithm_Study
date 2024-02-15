package swea9;

import java.util.Scanner;

public class psy_10431_줄세우기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();

		for (int i = 1; i <= tc; i++) {
			int N = sc.nextInt();
			int[] arr = new int[20];
			int count = 0;

			for (int j = 0; j < 20; j++) {
				arr[j] = sc.nextInt();
			}
			for (int j = 1; j < 20; j++) {
				int tmp = arr[j];
				int k;
				for (k = j - 1; k >= 0 && arr[k] > tmp; k--) {
					arr[k + 1] = arr[k];
					count++;
				}
				arr[k + 1] = tmp;
			}
			System.out.println(N + " " + count);
		}
	}
}
