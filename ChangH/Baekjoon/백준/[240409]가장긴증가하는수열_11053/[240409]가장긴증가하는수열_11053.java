package B11053;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	//입력도구
	static int A;
	static int[] arr, dp;
	//변수
	public static void main(String[] args) throws IOException {
		test();
	}
	private static void test() throws IOException {
		A = Integer.parseInt(br.readLine().trim());
		st = new StringTokenizer(br.readLine().trim());
		arr= new int[A+1];
		dp = new int[A+1];
		//변수 초기화 선언
		for(int i = 1 ; i <= A; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			//데이터를 받으면서
			int max = 0;
			for(int j= 0; j<i; j++) {
				if(arr[j] < arr[i] && dp[j]>max) {
					//지금 받은 것 이전 중, 지금 받은것보다 작으면서 가장 큰 수열을 찾아서
					max = dp[j];
				}
			}
			dp[i] = max+1; //그것에 +1해서 넣겠다.
		}
		Arrays.sort(dp);
		System.out.println(dp[A]); //마지막 것이 가장 큰것
	}
}
