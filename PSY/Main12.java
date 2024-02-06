import java.util.Scanner;

public class Main12 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[][]  arr = new int [100][100];
		int[] input = new int[16];
		
		for(int i = 0; i < 4;i++) {
			int minX = sc.nextInt();
			int minY = sc.nextInt();
			int maxX = sc.nextInt();
			int maxY = sc.nextInt();
			
			for(int r = minX; r < maxX;r++) {
				for(int c = minY; c < maxY;c++) {
					arr[r][c] = 1;
				}
			}
		}
		int sum = 0;
		for(int r = 0; r < 100;r++) {
			for(int c = 0; c < 100;c++) {
				sum += arr[r][c];
			}
		}
		System.out.println(sum);
	}
}
