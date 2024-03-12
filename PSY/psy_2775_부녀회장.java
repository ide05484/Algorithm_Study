import java.util.Scanner;

public class psy_2775_부녀회장 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[][] arr = new int[15][15]; // 아파트 생성
		for (int r = 0; r < 15; r++) {
			for (int c = 0; c < 15; c++) {
				if (r == 0) // 0층의 아파트 사람수 채우기
					arr[r][c] = c + 1;
				else // 1층 이상의 아파트 사람수 채우기
					for (int c2 = 0; c2 <= c; c2++) { 
						arr[r][c] += arr[r - 1][c2];
					}
			}
		}
		int tc = sc.nextInt();
		for (int i = 0; i < tc; i++) { // 출력
			System.out.println(arr[sc.nextInt()][sc.nextInt() - 1]);
		}
	}
}
