import java.util.Scanner;

public class psy_2578_빙고 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[][] arr = new int[5][5];
		for (int r = 0; r < 5; r++) {
			for (int c = 0; c < 5; c++) {
				arr[r][c] = sc.nextInt();
			}
		}

		for (int i = 1; i <= 25; i++) {
			int num = sc.nextInt();
			for (int r = 0; r < 5; r++) {
				for (int c = 0; c < 5; c++) {
					if (arr[r][c] == num)
						arr[r][c] = -1;
				}
			}
			if (check(arr)) {
				System.out.println(i);
				break;
			}
		}
	}

	static boolean check(int[][] arr) {
		int count = 0;
		for (int r = 0; r < 5; r++) {
			for (int c = 0; c < 5 && arr[r][c] == -1; c++) {
				if (c == 4)
					count++;
			}
		}

		for (int c = 0; c < 5; c++) {
			for (int r = 0; r < 5 && arr[r][c] == -1; r++) {
				if (r == 4)
					count++;
			}
		}

		for (int r = 0, c = 0; r < 5&& arr[r][c] == -1 ;r++,c++) {
			if(r == 4)
				count++;
		}
		
		for (int r = 0, c = 4; r < 5&& arr[r][c] == -1 ;r++,c--) {
			if(r == 4)
				count++;
		}

		return count >= 3;
	}
}
