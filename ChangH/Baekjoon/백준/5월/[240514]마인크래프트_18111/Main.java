package B18111;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N, M, B, min, max, resultsec, resultheight;
	static int[][] board;

	public static void main(String[] args) throws Exception {
		test();
	}

	private static void test() throws Exception {
		testInput();
		testProcess();
		testOutput();
	}

	private static void testInput() throws Exception {
		st= new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		min = 256;
		max = 0;
		resultsec = Integer.MAX_VALUE;
		board = new int[N][M];
		for(int i = 0 ; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				min = Math.min(min, board[i][j]);
				max = Math.max(max, board[i][j]);
			}
		}
		//초기화
	}

	private static void testProcess() {
		a: for(int m = min; m<=max; m++) {
			int tmp = B;
			int tmpsec = 0;
			for(int i = 0; i<N; i++) {
				for(int j = 0; j<M; j++) {
					if(m<board[i][j]) {
						tmpsec += (board[i][j]-m) *2;
						tmp += board[i][j]-m;
					} else if(m>board[i][j]) {
						tmp -= m-board[i][j];
						tmpsec += (m-board[i][j]);
					}
					if(tmpsec>resultsec) {
						continue a;
					}
				}
			}
			if(tmp>=0) {
				resultsec = tmpsec;
				resultheight = m;
			}
		}
		// 각 높이에 대해 필드를 돌면서 얼마나 걸리는지 확인
	}

	private static void testOutput() {
		System.out.println(resultsec + " " + resultheight);
	}
}