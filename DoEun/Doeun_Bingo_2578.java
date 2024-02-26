package baekjoon_IM;

import java.util.Scanner;

public class Bingo_2578 {

	static int[][] bingo;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		bingo = new int[5][5]; // 빙고판

		for (int r = 0; r < 5; r++) {
			for (int c = 0; c < 5; c++) {
				bingo[r][c] = sc.nextInt();
			}
		}

//		for (int r = 0; r < 5; r++) {
//			for (int c = 0; c < 5; c++) {
//				System.out.print(bingo[r][c]+" ");
//			}
//			System.out.println();
//		} //잘들어갔어용

		int answer = 0; // 답
		int count; // 빙고갯수세기

		for (int i = 0; i < 25; i++) {
			int num = sc.nextInt(); // 25번 숫자를 받을건데

			count = 0; // 초기화
			// 불러주는 숫자 입력받기
			for (int r = 0; r < 5; r++) {
				for (int c = 0; c < 5; c++) {
					if (bingo[r][c] == num) {
						bingo[r][c] = 0; // 같은게 있으면 0으로 바꿔주세용
					}
				}
			} // 돌면서 하나씩 바꿔줌

			// 끝나기 전에 검사
			if (bingoR()) {
				count++;
			}
			if (bingoC()) {
				count++;
			}
			if (bingoX()) {
				count++;
			}
			if (bingoY()) {
				count++;
			}

//				System.out.println(bingoR()+"R");
//				System.out.println(bingoC()+"C");
//				System.out.println(bingoX()+"X");
//				System.out.println(bingoY()+"Y");

			if (count == 3) { // 빙고가 되면
				answer = i + 1; // 횟수는 인덱스 +1
				break;
			}
		}

		System.out.println(answer);

	}

	// 세로빙고
	static boolean bingoR() {
		// 열우선 순회를 돌면서
		to: for (int c = 0; c < 5; c++) {
			for (int r = 0; r < 5; r++) {
				// 0으로 바꿔줄거니까 0이 아닌게 있으면 빙고가 아님
				if (bingo[r][c] != 0) {
					continue to; // r이 있는 for문만 나감
				}
			}
			return true;
		}
		// 아예 나와버리면... 아무것도 없는거임
		return false;
	}

	// 가로빙고
	static boolean bingoC() {
		// 행우선 순회를 돌면서
		to: for (int r = 0; r < 5; r++) {
			for (int c = 0; c < 5; c++) {
				// 0으로 바꿔줄거니까 0이 아닌게 있으면 빙고가 아님
				if (bingo[r][c] != 0) {
					continue to; // r이 있는 for문만 나감
				}
			}
			// 여기로 나오면 하나 잇는 거임!
			return true;
		}
		// 아예 나와버리면... 아무것도 없는거임
		return false;
	}

	// 대각선올라가는
	static boolean bingoX() {
		// 행우선 순회를 돌면서
		for (int r = 0; r < 5; r++) {
			// 0으로 바꿔줄거니까 0이 아닌게 있으면 빙고가 아님
			if (bingo[r][4 - r] != 0) {
				return false;
			}
		}
		// 여기오면 잇는거임!
		return true;
	}

	// 대각선내려가는
	static boolean bingoY() {
		// 행우선 순회를 돌면서
		to: for (int r = 0; r < 5; r++) {
			// 0으로 바꿔줄거니까 0이 아닌게 있으면 빙고가 아님
			if (bingo[r][r] != 0) {
				return false;
			}
			// 여기로 나오면 하나 잇는 거임!
		}
		// 여기오면 잇는거임!
		return true;
	}
}
