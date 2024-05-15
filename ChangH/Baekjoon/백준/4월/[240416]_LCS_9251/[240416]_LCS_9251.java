package B9251;

import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	//입력 도구
	static String A, B;
	static int[][] dp;
	//두 단어와 DP;
	public static void main(String[] args) {
		test();
	}

	private static void test() {
		testInput();
		testProcess();
		testOutput();
	}

	private static void testInput() {
		A = sc.nextLine();
		B = sc.nextLine();
		dp = new int[A.length()+1][B.length()+1];
		//변수 초기화 및 입력
	}

	private static void testProcess() {
		for(int i = 1; i <= A.length(); i++) {
			//A를 돌면서
			for(int j = 1; j <= B.length(); j++) {
				//B 전체와 비교
				if(A.charAt(i-1) == B.charAt(j-1)) {
					//만약 해당 문자열이 같다면 각각 이전 문자열(최댓값)에서 +1
					dp[i][j] = dp[i-1][j-1] + 1;
				} else {
					//만약 문자가 다르다면 기존 길이중 최댓값을 갖고 온다.
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
	}

	private static void testOutput() {
		System.out.println(dp[A.length()][B.length()]);
	}
	
}
