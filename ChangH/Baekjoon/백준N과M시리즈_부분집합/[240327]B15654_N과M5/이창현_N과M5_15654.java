package B15654_N과M5;
import java.util.Scanner;

public class 이창현_N과M5_15654 {
	static Scanner sc = new Scanner(System.in);
	static StringBuilder sb = new StringBuilder();
	static int N, M;
	static int[] printArr;
	public static void main(String[] args) {
		test();
	}
	private static void test() {
		testInput();
		testProcess(1, 0);
		testOutput();
	}
	private static void testInput() {
		N = sc.nextInt();
		M = sc.nextInt();
		printArr= new int[M];
	}
	private static void testProcess(int n, int m) {
		if(m>=M) {
			for(int i = 0 ; i<M ; i++) {
				sb.append(printArr[i]+" ");
			}
			sb.append("\n");
			return;
		}
		if(n>N) {
			return;
		}
		printArr[m]=n;
		testProcess(n, m+1);
		testProcess(n+1, m);
		
	}
	private static void testOutput() {
		System.out.println(sb.toString());
	}
}