package swea;

import java.util.Scanner;

public class psy_1978_소수찾기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int count = 0;
		for (int i = 0; i < N; i++) {
			int num = sc.nextInt();
			boolean flag = false;
			for (int j = 2; j <= num; j++) {
				if(flag)
					break;
				if (num % j == 0) {
					flag = true;
				}
				if (j == num)
					count++;
			}
		}
		System.out.println(count);
	}
}
