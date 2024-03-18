package B11050;

import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static int N, K, tmp1, tmp2, result;
	public static void main(String[] args) {
		test();
	}
	private static void test() {
		testInput();
		testProcess();
		testOutput();
	}
	private static void testInput() {
		N= sc.nextInt();
		K= sc.nextInt();
		tmp1=1;
		tmp2=1;
	}
	private static void testProcess() {
		for(int i= 0; i<K; i++) {
			tmp1*= (N-i);
			tmp2*= (i+1);
		}
		result=tmp1/tmp2;
	}
	private static void testOutput() {
		System.out.println(result);
	}
}
