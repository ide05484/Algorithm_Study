import java.util.Scanner;

public class yoonji_2669_직사각형면적 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);	
		int[][] arr = new int [101][101];
		int count = 0;
		
		for(int i = 0; i < 4; i ++ ) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			
			for(int r = x1; r < x2; r++) {
				for(int c = y1; c < y2 ;c++) {
					arr[r][c] =+ 1;
				}
			}
		}
		
		for(int r = 1; r < 101; r++) {
			for(int c = 1; c < 101; c++) {
				if(arr[r][c] >= 1) {
					count++;
				}
			}
		}
		System.out.println(count);
	}
}
