package S2115;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	//입력 도구
	
	static int T;
	//테스트 케이스
	static int N, M, C; //벌집 크기, 수확 크기, 최대 수확량
	static int[][][] beeFarm; // 벌집[][] 벌집 꿀량[0], 꿀 수익[1];
	static int[][] dp; //각 지점에서 얻을 수 있는 최대 수익
	//변수 선언
	
	static int result; // 결과
	//출력 도구
	
	public static void main(String[] args) throws IOException {
		test();
	}

	private static void test() throws IOException {
		T = Integer.parseInt(br.readLine().trim());
		for(int tc = 1; tc<= T; tc++) {
			testInput();
			testProcess();
			testOutput(tc);
		}
	}

	private static void testInput() throws IOException {
		st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		beeFarm = new int[N][N][2];
		dp = new int[N][N];
		for(int i = 0 ; i<N; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for(int j = 0 ; j<N; j++) {
				beeFarm[i][j][0] = Integer.parseInt(st.nextToken());
				beeFarm[i][j][1] = beeFarm[i][j][0] * beeFarm[i][j][0];
			}
		}
		result = 0;
		//데이터 초기화 및 입력
	}

	private static void testProcess() {
		for(int i = 0 ; i<N; i++) {
			for(int j = 0; j<N; j++) {
				check(0, 0, 0, i, j); //모든 지점에 대해서 최대 수익 점검
			}
		}
		for(int i = 0 ; i<N; i++) {
			for(int j = 0; j<N; j++) {
				int a = dp[i][j]; //모든 시작점에 대해
				for(int k = i ; k<N; k++) { //대응 가능한 이후의 다른 시작점으로
					for(int l = i==k?j+M:0; l<N; l++) {
						result = Math.max(result, a+dp[k][l]); //선택 가능한 최대합 추출
					}
				}
			}
		}
	}

	private static void check(int now, int sum, int benefit, int r, int c) {
		if(sum > C) {
			return;
		}
		if(now>=M || now+c>=N) { //M개의 배열을 살폈거나 통의 끝이라면
			dp[r][c] = Math.max(dp[r][c], benefit);
			return;
		}
		check(now +1, sum, benefit, r, c); //선택 안하고 넘어갈때
		check(now +1, sum + beeFarm[r][c+now][0], benefit + beeFarm[r][c+now][1], r, c); //선택 하고 넘어갈때
		
		
	}

	private static void testOutput(int tc) {
		System.out.println("#" + tc + " " + result); //출력
	}
}
