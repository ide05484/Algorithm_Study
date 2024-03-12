package B2609;

import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static int N, M, GCD; static long LCM; //각 두 수와 최대, 최소
	public static void main(String[] args) {
		test();
	}
	private static void test() {
		testInput();
		testProcess();
		testOutput();
	}
	private static void testInput() {
		N = sc.nextInt(); //N 
		M = sc.nextInt(); //M
	}
	private static void testProcess() {
		int tmp = 1; //임시변수
		int n = N; //임시변수
		for(int i = 2; i<=N; i++) { //작은 수부터
			while(N%i==0 && M%i==0) { //나눠서 둘다 나머지가 0일때
				N /=i;
				M /=i;
				tmp *=i;
			}
		}
		GCD = tmp; 
		LCM = n*M; //최대공약수가 빠져나간 M에 기존 N값을 곱하면 LCM
	}
	private static void testOutput() {
		System.out.println(GCD + "\n" + LCM);
	}
}
