import java.util.Scanner;

public class psy_10157_자리배정 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int C = sc.nextInt(); // 가로
		int R = sc.nextInt(); // 세로
		int[] dr = { -1, 0, 1, 0 }; // 델타 배열
		int[] dc = { 0, 1, 0, -1 };

		int[][] arr = new int[R][C];// 2차원 배열 생성
		int d = 0;
		int nr = R - 1; // 첫 위치 N값
		int nc = 0; // 첫 위치 C값
		int whereSeat = sc.nextInt();
		if (whereSeat > R * C) { // 자리보다 큰 번호시 0출력
			System.out.println("0");
			return;
		}
		for (int i = 1; i <= whereSeat; i++) {
			arr[nr][nc] = i;
			if (nr + dr[d] < 0 || nc + dc[d] < 0 || nr + dr[d] >= R || nc + dc[d] >= C
					|| arr[nr + dr[d]][nc + dc[d]] != 0) // 다음 갈 지점이 범위 밖이거나 숫자가 이미 채워져있다면 회전
				d = (d + 1) % 4;
			if(i == whereSeat) { // 자리에 맞는 번호시 출력
				System.out.println(nc+1+" "+(R-nr));
			}
			nr += dr[d]; // 다음에 갈 위치로 변환
			nc += dc[d];
		}
	}
}
