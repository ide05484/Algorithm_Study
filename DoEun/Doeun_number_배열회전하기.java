package IM;

import java.util.Scanner;

public class number_배열회전하기 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt(); //테스트 케이스 갯수
		
		for(int tc = 1; tc<=T; tc++) {
			int N = sc.nextInt(); //배열크기
			int[][] num = new int[N][N]; //배열
			
			for(int r = 0; r<N; r++) {
				for(int c=0; c<N; c++) {
					num[r][c] = sc.nextInt(); //해당 배열에 받는 문자열
				}
			}
			
			int[][] num_90 = new int[N][N];
			
			//90도 회전
			for(int r = 0; r<N; r++) {
				for(int c = 0; c<N; c++) {
					num_90[c][N-r-1] = num[r][c];
					//90도 회전은 r이 c와 같고, c가 r과 더해서 N-1이 되어야함
				}
			}
			
			int[][] num_180 = new int[N][N];
			
			//180도 회전
			for(int r = 0; r<N; r++) {
				for(int c = 0; c<N; c++) {
					num_180[r][c] = num[N-1-r][N-1-c];
					//180회전은 예전 r과 지금 r의 합이 N-1 (c도 똑같음)
				}
			}
			
			int[][] num_270 = new int[N][N];
			
			//270도 회전
			for(int r = 0; r<N; r++) {
				for(int c = 0; c<N; c++) {
					num_270[r][c] = num[c][N-r-1];
					//역 90도는 위치륿 바꾸면 대!
				}
			}
			
			System.out.println("#"+tc);
			
			for(int r = 0; r<N; r++) {
				for(int c = 0; c<N; c++) {
					System.out.print(num_90[r][c]);
				}
				System.out.print(" ");
				for(int c = 0; c<N; c++) {
					System.out.print(num_180[r][c]);
				}
				System.out.print(" ");
				for(int c = 0; c<N; c++) {
					System.out.print(num_270[r][c]);
				}
				
				System.out.println();
			}
			
			
		}//테케마감
	}//main마감
}
