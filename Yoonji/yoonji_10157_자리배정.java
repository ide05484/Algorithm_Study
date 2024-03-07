import java.util.Scanner;

public class yoonji_10157_자리배정 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int C = sc.nextInt(); // 가로 column
		int R = sc.nextInt(); // 세로 row
		int K = sc.nextInt();
		
		int[][] arr = new int [R][C];
		
		int[] dr = {-1, 0, 1, 0}; // 상 우 하 좌
		int[] dc = {0, 1, 0, -1}; // 상 우 하 좌
		
		for(int r = R - 1; r >= 0; r--) {
			for(int c = C - 1; c >= 0; c--) {
				
				int d = 0;
				int nr = r + dr[(d % 4)];
				int nc = c + dc[(d % 4)];
				
				if(nr >= 0 && nr < R && nc >= 0 && nc < C) {
					r = nr;
					c = nc;
				} else if (arr[nr][nc] != 0) {
					d++;
				}

			}
		}
		
		

	}

}
