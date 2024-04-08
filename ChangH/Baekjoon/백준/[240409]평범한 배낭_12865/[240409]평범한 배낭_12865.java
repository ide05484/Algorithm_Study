package B12865;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	//입력 도구
	static int N, K;
	static int[] W, V;
	static int[][] dp;
	//변수
	public static void main(String[] args) throws IOException {
		test();
	}

	private static void test() throws IOException {
		testInput();
		testProcess();
		testOutput();
	}

	private static void testInput() throws IOException {
		st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		W = new int[N+1];
		V = new int[N+1];
		for(int i = 1 ; i<= N; i++) {
			st = new StringTokenizer(br.readLine().trim());
			W[i] = Integer.parseInt(st.nextToken());
			V[i] = Integer.parseInt(st.nextToken());
		}
		dp = new int[N+1][K+1];
		//데이터 입력 및 초기화
	}

	private static void testProcess() {
		for(int i = 1 ; i<=N; i++) {
			for(int j = 0; j <= K; j++) {
				if(j >= W[i]) {  //현재 보고 있는 물건을 넣을 수 있는 순간부터
					dp[i][j] = Math.max(dp[i-1][j-W[i]] + V[i], dp[i-1][j]); //넣는게 이득이면 넣고, 아니면 만다.
				} else {
					dp[i][j] = dp[i-1][j]; //이전 물건 계승
				}
				
			}
		}
		
	}

	private static void testOutput() {
		System.out.println(dp[N][K]); //제일 마지막 값이 항상 가장 큰값
	}
	
}
