package DFS;
import java.util.Scanner;

public class 유기농배추_1012 {

	static int T, R, C, N, count;
	static int[][] field;
	static boolean[][] visited;
	static int[] dx;
	static int[] dy;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			
			R = sc.nextInt(); // 가로 길이
			C = sc.nextInt(); // 세로 길이
			N = sc.nextInt(); // 배추 심은 수
			count = 0; // 몇 개의 덩어리인지

			field = new int[R][C]; // 배추밭
			visited = new boolean[R][C]; // 방문 배열 체크

			// 해당 위치에 배추 심기
			for (int n = 0; n < N; n++) {
				int r = sc.nextInt();
				int c = sc.nextInt();
				field[r][c] = 1;
			}

			// 모든 배열을 확인할 것인데(배추밭과 방문 배열 체크)
			for (int r = 0; r < R; r++) {
				for (int c = 0; c < C; c++) {
					// 방문 배열 체크: 아직 방문하지 않았으면서
					// 배추밭: 배추가 심어져 있다면
					if (visited[r][c] == false && field[r][c] == 1) {
						// 해당 위치에 대해서 다시 DFS를 실행한다. 그리고 count 덩어리 수를 하나 증가시킨다.
						DFS(r, c);
						count++;
					}
				}
			}
			
			// 총 count 덩어리 수를 출력한다.
			System.out.println(count);
		}

	}

	private static void DFS(int r, int c) {
		// 방문 배열 체크: 현재 위치를 true로 바꿔주고
		visited[r][c] = true;

		// 상하좌우 위치를 확인할 것인데
		int[] dr = { 1, -1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };

		// 0 1 2 3 상하좌우 확인할 것이고
		for (int i = 0; i < 4; i++) {
			// 다음 좌표 값을 구해주고
			int nr = r + dr[i];
			int nc = c + dc[i];
			// 범위를 벗어나지 않으면서
			// 방문 배열 체크: 아직 방문하지 않았으면서
			// 배추밭: 배추가 심어져 있다면
			// 해당 위치에 대해서 다시 DFS를 실행한다.
			// -> 인접 범위의 모든 배추가 심어져있는 부분을 확인한다.
			if (nr >= 0 && nr < R && nc >= 0 && nc < C &&
					visited[nr][nc] == false && field[nr][nc] == 1) {
				DFS(nr, nc);
			}
		}
	}

}
