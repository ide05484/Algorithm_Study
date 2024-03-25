package N240326B15665_N과M11;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static StringBuilder sb = new StringBuilder();
	static int N, M, tmp;
	static int[] printArr, Arr;
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
		boolean[] info= new boolean[10001];
		for(int i = 0; i< N; i++) {
			if(!info[Arr[i]]) {
				info[Arr[i]]=true;
				printArr[m]=Arr[i];
				testProcess(m+1);

			}
		}
	}
	private static void testOutput() {
		System.out.println(sb.toString());
		
	}
}
