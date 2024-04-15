package B2294;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static Scanner sc= new Scanner(System.in);
	static int N, K, Min;
	static int INF = 987654321;
	static int[] arr;
	static int[][] dp;
	public static void main(String[] args) {
		test();
	}
	private static void test() {
		testInput();
		testProcess();
		testOutput();
	}
	private static void testInput() {
		N = sc.nextInt();
		K = sc.nextInt();
		arr = new int[N+1];
		dp = new int[N+1][K+1];
		Arrays.fill(dp[0], INF);
		dp[0][0] = 0;
		for(int i = 1; i<=N; i++) {
			arr[i] = sc.nextInt();
			Arrays.fill(dp[i], INF);
			dp[i][0] = 0;
		}
	}
	private static void testProcess() {
		Arrays.sort(arr);
		
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j<= K; j++) {
				if(arr[i]>j) {
					dp[i][j] = dp[i-1][j];
				} else {
					dp[i][j] = Math.min(dp[i-1][j], dp[i][j-arr[i]]+1);
				}
			}
		}
		
		Min = INF;
		for(int i = 1; i <= N; i++) {
			Min = Math.min(dp[i][K], Min);
		}
		if(Min == INF) {
			Min = -1;
		}
		
	}
	
	private static void testOutput() {
		System.out.println(Min);
	}
	
}
