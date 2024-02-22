import java.util.Scanner;

public class psy_1959_두개의숫자열 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int tc = sc.nextInt();
		for (int i = 1; i <= tc; i++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[] arr1 = new int[N];
			int[] arr2 = new int[M];

			for (int j = 0; j < N; j++) {
				arr1[j] = sc.nextInt();
			}
			for (int j = 0; j < M; j++) {
				arr2[j] = sc.nextInt();
			}
			int max = Integer.MIN_VALUE;

			if (N > M) {
				for (int j = 0; j <= N - M; j++) {
					int sum = 0;
					for (int k = 0; k < M; k++) {
						sum += arr1[j + k] * arr2[k];
					}
					if (sum > max)
						max = sum;
				}
			}else {
				for (int j = 0; j <= M - N; j++) {
					int sum = 0;
					for (int k = 0; k < N; k++) {
						sum += arr1[k] * arr2[j+k];
					}
					if (sum > max)
						max = sum;
				}
			}
			System.out.println("#"+i+" "+max);
		}
	}
}
