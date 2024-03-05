package IM;

import java.util.Scanner;

public class Millionaire {

	static int[] money;
	static int N;
	static long[] profit;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {

			N = sc.nextInt(); // 주어지는 나날들
			money = new int[N]; // 받을 돈 배열
			profit = new long[N];

			for (int n = 0; n < N; n++) {
				money[n] = sc.nextInt();// 해당 날에 받을 돈
			}

			// 전부 똑같으면 return 0
			if (isSame())
				System.out.println(0);
			
			findProfit(); //이익 구하셈
			
			long sum = 0; //합계 구하기 //범위체크!!!
			
			for(int p = 0; p<N; p++) {
				sum += profit[p]; //이익에 들어가있는거 구하기
			}
			
			System.out.println("#"+tc+" "+sum);

		} // 테케마감
	} // main마감

	// 계속 같은 숫자만 있는건가요?
	static boolean isSame() {
		for (int n = 0; n < N - 1; n++) {
			if (money[n] != money[n + 1]) {
				return false;
			}
		}
		return true;
	}
	
	// 최대값을 구하고 그전까지의 이익 구하기
	static void findProfit() {
		int max = 0;

		// 뒤에서 보면서 최대값 갱신하면서 본인이랑 비교하기
		for (int i = N - 1; i >= 0; i--) {
			max = Math.max(max, money[i]); //계속 max갱신하면서
			profit[i] = max - money[i]; //profit 배열에 넣어줌
		}
	}
}// 클래스 끝
