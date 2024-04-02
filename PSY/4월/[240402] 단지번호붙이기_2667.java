import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class psy_2667_단지번호붙이기 {
	static int[][] arr;
	static int count, N;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine()); // 단지 크기 
		arr = new int[N][N]; // 배열 생성

		for (int r = 0; r < N; r++) { // 입력받기
			String str = br.readLine();
			for (int c = 0; c < N; c++) {
				arr[r][c] = str.charAt(c) - '0';
			}
		}

		int result = 0; // 결과값 받을 변수
		int[] counting = new int[25 * 25 + 1]; // 카운팅 배열

		for (int r = 0; r < N; r++) { 
			for (int c = 0; c < N; c++) {
				if (arr[r][c] == 1) { // 1이면 탐색  
					count = 0; // 하나의 아파트 단지 세주는 변수
					result++;  // 아파트 단지 수
					dfs(r, c);
					counting[count]++;
				}
			}
		}
		System.out.println(result);
		for (int i = 0; i < counting.length && result > 0; i++) { // 출력
			if (counting[i] != 0) {
				result--;
				System.out.println(i);
				counting[i]--;
				i--;
			}
		}
	}

	static void dfs(int r, int c) { // 돌면서 같은 단지 지워주기
		count++;
		arr[r][c] = 0;

		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if (nr >= 0 && nc >= 0 && nr < N && nc < N && arr[nr][nc] == 1) {
				dfs(nr, nc);
			}

		}
	}
}
