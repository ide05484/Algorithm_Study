import java.util.Scanner;

public class yoonji_2578_빙고 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[][] arr = new int[5][5];
		// 배열 입력 받기
		for (int r = 0; r < 5; r++) {
			for (int c = 0; c < 5; c++) {
				arr[r][c] = sc.nextInt();
			}
		}
		
		int bingo = 0;
		int count = 0;
		
		while (true) {
			bingo = 0;
			int num = sc.nextInt();
			count++;

			// 해당 숫자값 0으로 바꾸고
			for (int r = 0; r < 5; r++) {
				for (int c = 0; c < 5; c++) {
					if (arr[r][c] == num) {
						arr[r][c] = 0;
					}
				}
			}
			//출력 확인 부분
//			System.out.println("----------------");
//			for (int r = 0; r < 5; r++) {
//				for (int c = 0; c < 5; c++) {
//					System.out.printf("%3d", arr[r][c]);
//				}
//				System.out.println();
//			}

			// 빙고를 확인
			// 1. 가로
			for (int r = 0; r < 5; r++) {
				boolean check = true;
				for (int c = 0; c < 5; c++) {
					if (arr[r][c] != 0) {
						check = false;
						break;
					}
				}
				if (check == true) {
					bingo++;
				}
			}

			// 2. 세로
			for (int c = 0; c < 5; c++) {
				boolean check = true;
				for (int r = 0; r < 5; r++) {
					if (arr[r][c] != 0) {
						check = false;
						break;
					}
				}
				if (check == true) {
					bingo++;
				}
			}

			// 3. 사선(오른쪽 아래방향)
			boolean check = true;
			out: for (int r = 0; r < 5; r++) {
				for (int c = 0; c < 5; c++) {
					if (r == c && arr[r][c] != 0) {
						check = false;
						if(check == false) {
							break out;
						}
					}
				}
			}
			if (check == true) {
				bingo++;
			}

			// 4. 사선(오른쪽 위방향)
			check = true;
			out1: for (int r = 0; r < 5; r++) {
				for (int c = 0; c < 5; c++) {
					if (r + c == 4 && arr[r][c] != 0) {
						check = false;
						if(check == false) {
							break out1;
						}
					}
				}
			}
			if (check == true) {
				bingo++;
			}
			// 한 방에 여러 빙고 고려 > 추가
			if(bingo >= 3) {
				break;
			}

		}
		//System.out.println("bingo: " + bingo);
		System.out.println(count);

	}

}
