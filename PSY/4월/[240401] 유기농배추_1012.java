import java.util.Scanner;

public class psy_1012_유기농배추 {
	static int[][] arr;
	static int N, M;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int tc = sc.nextInt(); // 테케
		for (int i = 0; i < tc; i++) {
			N = sc.nextInt(); // 행
			M = sc.nextInt(); // 열
			int K = sc.nextInt(); // 몇 줄?
			arr = new int[N][M]; // 베추밭 생성
			for (int j = 0; j < K; j++) { // 배추심은곳 1 넣기
				arr[sc.nextInt()][sc.nextInt()] = 1;
			}
			int result = 0; // 결과값
			for (int r = 0; r < N; r++) { // 배추밭 돌기
				for (int c = 0; c < M; c++) {
					if (arr[r][c] == 1) { // 1이면 결과값++ dfs돌기
						result++;
						dfs(r, c);
					}
				}
			}
			System.out.println(result); // 출력
		}
	}

	static void dfs(int r, int c) {
		if (r < 0 || c < 0 || r >= N || c >= M || arr[r][c] == 0) {
			return;
		}
		arr[r][c] = 0;
		dfs(r + 1, c);
		dfs(r - 1, c);
		dfs(r, c + 1);
		dfs(r, c - 1);

	}
}
