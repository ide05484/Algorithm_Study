package B15652_N과M4;

import java.util.Arrays;
import java.util.Scanner;

public class 이창현_N과M4_15652 {
	static Scanner sc = new Scanner(System.in);
	static StringBuilder sb = new StringBuilder();
	static int N, M, tmp;
	static int[] printArr, Arr;
	static boolean[] info;
	public static void main(String[] args) {
		test();
	}
	private static void test() {
		testInput();
		testProcess(0);
		testOutput();
	}
	private static void testInput() {
		N = sc.nextInt();
		M = sc.nextInt();
		tmp = 1;
		printArr= new int[M];
		Arr = new int[N];
		info = new boolean[N];
		for(int i = 0 ; i< N; i++) {
			Arr[i] = sc.nextInt();
		}
		Arrays.sort(Arr);
	}
	private static void testProcess(int m) {
		if(m>= M) {
			for(int i = 0 ; i < M ; i++) {
				sb.append(printArr[i]+ " ");
			}
			sb.append("\n");
			return;
		}
		for(int i = 0; i< N; i++) {
			if(!info[i]) {
				info[i]=true;
				printArr[m]=Arr[i];
				testProcess(m+1);
				info[i]=false;
			}
		}
	}
	private static void testOutput() {
		System.out.println(sb.toString());
		
	}
}