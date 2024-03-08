package B15829;

import java.util.Scanner;

public class 이창현_Hashing_15829 {
	static Scanner sc = new Scanner(System.in);
	static int L; //글자 수(안씀)
	static long result; //결과 해싱
	static String str; //문장
	static long r = 1; // (작은 서로소 시작문 1)
	static int M = 1234567891; //(적당히 큰 소수)
	public static void main(String[] args) {
		test(); //테스트
	}
	private static void test() {
		testInput(); //입력
		testProcess(); //실행
		testOutput(); //출력
	}
	private static void testInput() {
		L= Integer.parseInt(sc.nextLine()); //대충 버림
		str = sc.nextLine(); //문장
	}
	private static void testProcess() {
		for(int i = 0 ; i<str.length(); i++) { //문장 길이만큼 돌면서
			result += (str.charAt(i)-'a'+1)*r%M; //분배법칙
			r = (r*31)%M; //분배법칙
			result %=M; //제발 터지지 말아주세요.
		}
	}
	private static void testOutput() {
		System.out.println(result); //출력
	}
}
