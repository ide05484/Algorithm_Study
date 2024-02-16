package swea9;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class psy_1859_백만장자프로젝트 {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
//		Scanner sc = new Scanner(new File("input.txt"));

		int tc = sc.nextInt();
		for (int i = 1; i <= tc; i++) {
			int N = sc.nextInt();
			int[] arr = new int[N];

			for (int j = 0; j < N; j++) {
				arr[j] = sc.nextInt();
			}

			int max = arr[N - 1];
			long sum = 0;
			for (int j = N - 1; j >= 0; j--) {
				if (max < arr[j])
					max = arr[j];
				else if(arr[j] < max)
					sum += max-arr[j];
			}
			System.out.println("#"+i+" "+sum);
		}

	}
}
