package B2292;

import java.util.Scanner;

public class 이창현_벌집_2292 {
	static Scanner sc = new Scanner(System.in);
	static int N, result; //N과 결과값
	static int nowMax = 1, cnt = 1; //nowmax==현재 벌집 한계치, cnt 증설된 벌집 층수
	static int increment = 6; //증설 기준치
	
	public static void main(String[] args) {
		test(); //테스트
	}

	private static void test() {
		testInput(); //입력
		testProcess(); //실행
		testOutput(); //출력
	}

	private static void testInput() {
		N=sc.nextInt(); // 입력
	}

	private static void testProcess() {
		while(true) {
			if(N>nowMax) { //벌집 cnt 층안에 N이 있을때까지
				nowMax += increment *cnt++; //벌집 확장
			} else {
				result = cnt; //있으면 반환 후 종료
				return;
			}
		}
	}

	private static void testOutput() {
		System.out.println(result); //출력
	}
}
