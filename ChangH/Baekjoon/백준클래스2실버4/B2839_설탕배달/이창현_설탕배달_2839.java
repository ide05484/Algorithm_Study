package B2839_설탕배달;

import java.util.Scanner;

public class 이창현_설탕배달_2839 {
	static Scanner sc = new Scanner(System.in);
	static int N, kg3, kg5, result;
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
	}
	private static void testProcess() {
		kg5= N/5;
		while(kg5>=0) {
			if((N-(kg5 *5))%3==0) {
				kg3 = (N-(kg5*5))/3;
				result = kg3+kg5;
				return;
			}
			kg5--;
		}
		result=-1;
	}
	private static void testOutput() {
		System.out.println(result);
	}
	
}