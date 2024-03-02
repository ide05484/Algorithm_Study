package baekjoon_IM;

import java.util.Scanner;

public class 수이어가기_2635 {

	static int count = 2;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int num = sc.nextInt(); // 첫번째 숫자

		for (int i = 1; i < num; i++) {
			System.out.print(num + " " + findNext(num, i));
		}
	}

	// 다음 숫자 구하는 메서드
	static int findNext(int num, int num2) {

		if (num - num2 < 0) {
			return -11111;
		}

		int num3 = num - num2;
		count++;
		findNext(num2, num3);
		return num3;
	}
}
