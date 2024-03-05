package baekjoon_IM;

import java.util.Scanner;

public class Ant_10158 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int W = sc.nextInt();
		int H = sc.nextInt();

		int P = sc.nextInt(); // 시작좌표x
		int Q = sc.nextInt(); // 시작좌표y

		double t = sc.nextDouble(); // 움직일 시간

		boolean rightUp = true; // 무조건 오른쪽 위로 시작
		boolean leftUp = false;
		boolean leftDown = false;
		boolean rightDown = false;

		// 시간이 줄때까지
		for (double i = t; i > 0; i--) {

			if (rightUp) {
				P++; // 오른쪽 위는 x++ y++
				Q++;
				if (P == W && Q == H) { // 모서리라면~
					leftDown = true;
					rightUp = false;
				} else if (Q == H) { // 모서리가 아닌 경계
					rightDown = true;
					rightUp = false;
				} else if (P == W) {
					leftUp = true;
					rightUp = false;
				}
			}

			else if (leftUp) {
				P--;
				Q++;
				if (P == 0 && Q == H) {
					rightDown = true;
					leftUp = false;
				} else if (Q == H) {
					leftDown = true;
					leftUp = false;
				} else if (P == 0) {
					rightUp = true;
					leftUp = false;
				}
			}

			else if (leftDown) {
				P--;
				Q--;
				if (P == 0 && Q == 0) {
					rightUp = true;
					leftDown = false;
				} else if (Q == 0) {
					leftUp = true;
					leftDown = false;
				} else if (P == 0) {
					rightDown = true;
					leftDown = false;
				}
			}

			else if (rightDown) {
				P++;
				Q--;
				if (P == W && Q == 0) {
					leftUp = true;
					rightDown = false;
				} else if (Q == 0) {
					rightUp = true;
					rightDown = false;
				} else if (P == W) {
					leftDown = true;
					rightDown = false;
				}
			}
			
//			System.out.println(P + " " + Q);
		} // t시간만큼 움직임
		System.out.println(P + " " + Q);
	}
}
