package B15829;

import java.util.Scanner;

public class 이창현_Hashing_15829 {
	static Scanner sc = new Scanner(System.in);
	static int L; 
	static long result;
	static String str;
	static long r = 1;
	static int M = 1234567891;
	public static void main(String[] args) {
		test();
	}
	private static void test() {
		testInput();
		testProcess();
		testOutput();
	}
	private static void testInput() {
		L= Integer.parseInt(sc.nextLine());
		str = sc.nextLine();
	}
	private static void testProcess() {
		for(int i = 0 ; i<str.length(); i++) {
			result += (str.charAt(i)-'a'+1)*r%M; //분배법칙
			r = (r*31)%M; //분배법칙
			result %=M; //제발 터지지 말아주세요.
		}
	}
	private static void testOutput() {
		System.out.println(result);
	}
}
