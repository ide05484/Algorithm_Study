package B1436_영화감독숌;

import java.util.Scanner;

public class 이창현_영화감독숌_1436 {
	static Scanner sc = new Scanner(System.in);
	static int N, result;
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
		for(int i = 666 ; i<= Integer.MAX_VALUE; i++) {
			if((i+"").contains("666")) {
				N--;
				if(N==0) {
					result=i;
					return;
				}
			}
		}
		
		
	}
	private static void testOutput() {
		System.out.println(result);
	}
}