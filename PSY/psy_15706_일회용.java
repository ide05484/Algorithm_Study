package swea7;

import java.util.Scanner;

public class psy_15706_일회용{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int tc = sc.nextInt();
		for (int i = 0; i < tc; i++) {
			int N = sc.nextInt();
			int k_min = sc.nextInt();
			int k_max = sc.nextInt();
			int[] count = new int[101];

			for (int j = 0; j < N; j++) {
				count[sc.nextInt()]++;
			}

			for (int j = 1; j < 101; j++) {
				count[j] += count[j - 1];
			}
			int min = Integer.MAX_VALUE;
			for (int j = 1; j <= 99; j++) {
				if (count[j] < k_min)
					continue;
				if (count[j] > k_max)
					break;
				for (int k = j + 1; k <= 100; k++) {
					if (count[k] - count[j] < k_min || N - count[k] < k_min || N - count[k] > k_max)
						continue;
					if (count[k] - count[j] > k_max)
						break;
					int maxClass = Math.max(count[j], count[k] - count[j]);
					maxClass = Math.max(maxClass, N - count[k]);
					int minClass = Math.min(count[j], count[k] - count[j]);
					minClass = Math.min(minClass, N - count[k]);
					if (min > maxClass - minClass)
						min = maxClass - minClass;
				}
			}

			System.out.print("#" + (i + 1) + " ");
			if (min == Integer.MAX_VALUE)
				System.out.print(-1);
			else
				System.out.print(min);
			System.out.println();

		}
	}
}
