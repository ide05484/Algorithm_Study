import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static StringBuilder sb = new StringBuilder();
	static int N, M, tmp;
	static int[] printArr;
	static boolean[] Arr;
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
		Arr = new boolean[N+1];
		
	}
	private static void testProcess(int m) {
		if(m>= M) {
			for(int i = 0 ; i < M ; i++) {
				sb.append(printArr[i]+ " ");
			}
			sb.append("\n");
			return;
		}
		for(int i = 1; i<= N; i++) {
			if(!Arr[i]) {
				Arr[i]=true;
				printArr[m]=i;
				testProcess(m+1);
				Arr[i]=false;
			}
		}
	}
	private static void testOutput() {
		System.out.println(sb.toString());
		
	}
}
