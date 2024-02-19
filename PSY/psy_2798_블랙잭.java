import java.util.Arrays;
import java.util.Scanner;

public class psy_2798_블랙잭 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();

		int[] arr = new int[N];
		int max = 0;
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		Arrays.sort(arr);

		for (int i = 0; i < N - 2; i++) {
			out: for (int j = i + 1; j < N - 1; j++) {
				for (int k = j + 1; k < N; k++) {
					int sum = arr[i] + arr[j] + arr[k];
					if (sum > M)
						continue out;
					if (sum > max)
						max = sum;
				}
			}
		}
		System.out.println(max);
	}
}
