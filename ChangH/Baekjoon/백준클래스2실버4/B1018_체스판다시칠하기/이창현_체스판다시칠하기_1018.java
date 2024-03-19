package B1018_체스판다시칠하기;

import java.util.Scanner;

public class 이창현_체스판다시칠하기_1018 {
	static Scanner sc = new Scanner(System.in);
	static int N, M, result;
	static String[] board;
	static int[] chessBoard;
	public static void main(String[] args) {
		test();
	}
	private static void test() {
		testInput();
		testProcess();
		testOutput();
	}
	private static void testInput() {
		N= sc.nextInt();
		M= sc.nextInt();
		sc.nextLine();
		result=65;
		board = new String[N];
		for(int i = 0; i<N; i++) {
			board[i]= sc.nextLine(); 
		}
	}
	private static void testProcess() {
		for(int i = 0; i<=N-8; i++) {
			for(int j = 0 ; j<=M-8; j++) {
				check(i, j);
			}
		}
	}
	private static void check(int r, int c) {
		int tmp1 = 0;
		int tmp2 = 0;
		for(int i = r; i<r+8; i++) {
			for(int j = c; j<c+8; j++) {
				if((i+j)%2==0) {
					if(board[i].charAt(j)=='W') {
						tmp1++;
					} else {
						tmp2++;
					}
				} else {
					if(board[i].charAt(j)=='W') {
						tmp2++;
					} else {
						tmp1++;
					}
				}
			}
		}
		int tmp= Math.min(tmp1, tmp2);
		result = Math.min(result, tmp);
		return;
	}
	private static void testOutput() {
		System.out.println(result);
	}
}
