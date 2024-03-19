package B2869;

import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static int A, B, V, result; //A 올라갈 정도 B 내려가는 정도 V 막대 길이 result 결과
	public static void main(String[] args) {
		test();
	}

	private static void test() {
		testInput(); //입력
		testProcess(); //프로세스
		testOutput(); //출력
	}

	private static void testInput() {
		A= sc.nextInt();
		B= sc.nextInt();
		V= sc.nextInt();
	}

	private static void testProcess() {
		result= (int) Math.ceil((double)(V-B)/(A-B)); //V-B 위치에 도달했다면 떨어지기 전에는 정상이다.
	}

	private static void testOutput() {
		System.out.println(result); //출력
	}
}