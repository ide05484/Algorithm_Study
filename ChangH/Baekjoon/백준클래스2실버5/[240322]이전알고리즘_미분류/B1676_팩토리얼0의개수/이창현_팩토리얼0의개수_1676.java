package B1676_팩토리얼0의개수;

import java.util.Scanner;

public class 이창현_팩토리얼0의개수_1676 {
	static Scanner sc = new Scanner(System.in);
	static int N, tmp, cnt2, cnt5, result;
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
		for(int i = 1; i<=N;i++) {
			tmp = i;
			while(tmp%5==0) {
				cnt5++;
				tmp/=5;
			}
			while(tmp%2==0) {
				cnt2++;
				tmp/=2;
			}
		}
		result= Math.min(cnt2, cnt5);
	}
	private static void testOutput() {
		System.out.println(result);
	}
}