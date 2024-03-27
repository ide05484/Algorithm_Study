package B15657_N과M8;

import java.util.Arrays;
import java.util.Scanner;

public class 이창현_N과M8_15657 {
	static Scanner sc = new Scanner(System.in);
	static StringBuilder sb = new StringBuilder();
	static int N, M;
	static int[] printArr, Arr;
	public static void main(String[] args) {
		test();
	}
	private static void test() {
		testInput();
		testProcess(0, 0);
		testOutput();
	}
	private static void testInput() {
		N = sc.nextInt();
		M = sc.nextInt();
		printArr= new int[M];
		Arr= new int[N];
		for(int i= 0; i<N; i++) {
			Arr[i]=sc.nextInt();
		}
		Arrays.sort(Arr);
	}
	private static void testProcess(int n, int m) {
		if(m>=M) {
			for(int i = 0 ; i<M ; i++) {
				sb.append(printArr[i]+" ");
			}
			sb.append("\n");
			return;
		}
		if(n>=N) {
			return;
		}
		printArr[m]=Arr[n];
		testProcess(n, m+1);
		testProcess(n+1, m);
		
	}
	private static void testOutput() {
		System.out.println(sb.toString());
		
	}
}