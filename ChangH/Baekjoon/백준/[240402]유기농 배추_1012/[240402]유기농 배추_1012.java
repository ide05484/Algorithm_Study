package B1012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int T, N, M, K, result;
	static int[][] farm;
	static int[] dr = {1, -1, 0, 0};
	static int[] dc = {0, 0, 1, -1};
	public static void main(String[] args) throws IOException {
		test();
	}
	private static void test() throws IOException {
		T = Integer.parseInt(br.readLine());
		for(int tc = 1 ; tc<= T; tc++) {
			testInput();
			testProcess();
			testOutput();
		}
	}
	private static void testInput() throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		farm = new int[N][M];
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			farm[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
		}
		result = 0;
	}
	private static void testProcess() {
		for(int i = 0 ; i< N; i++) {
			for(int j = 0 ; j <M ; j++) {
				if(farm[i][j] == 1) {
					check(i, j);
					result++;
				}
			}
		}
	}
	private static void check(int i, int j) {
		farm[i][j] = 2;
		for(int d = 0 ; d < 4; d++) {
			if(i+dr[d] >= 0 && i+dr[d]<N && j+dc[d]>=0 && j+dc[d]<M && farm[i+dr[d]][j+dc[d]]==1) check(i+dr[d], j+dc[d]);
		}
		
	}
	private static void testOutput() {
		System.out.println(result);
	}
	
}