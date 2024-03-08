package B2292;

import java.util.Scanner;

public class 이창현_벌집_2292 {
	static Scanner sc = new Scanner(System.in);
	static int N, result;
	static int nowMax = 1, cnt = 1;
	static int increment = 6;
	
	public static void main(String[] args) {
		test();
	}

	private static void test() {
		testInput();
		testProcess();
		testOutput();
	}

	private static void testInput() {
		N=sc.nextInt();
	}

	private static void testProcess() {
		while(true) {
			if(N>nowMax) { //벌집 cnt 층안에 N이 있을때까지
				nowMax += increment *cnt++; //벌집 확장
			} else {
				result = cnt; //있으면 반환
				return;
			}
		}
	}

	private static void testOutput() {
		System.out.println(result);
	}
}