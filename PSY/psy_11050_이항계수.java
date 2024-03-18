package swea;

import java.util.Scanner;

public class psy_11050_이항계수 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] arr = new int[11];
		arr[0] = 1;
		arr[1] = 1;
		for (int i = 2; i < 11; i++) {
			arr[i] = arr[i - 1] * i;
		}
		int a = sc.nextInt();
		int b = sc.nextInt();
		System.out.println(arr[a]/arr[a-b]/arr[b]);
	}
}
