import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class psy_16174_점프왕쩰리 {
	static int[][] arr;
	static boolean[][] visited; // 방문
	static int N;
	static boolean result;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine()); // 게임판 크기
		arr = new int[N][N]; // 배열 생성
		visited = new boolean[N][N]; // 방문 배열

		for (int r = 0; r < N; r++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				arr[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		go(0, 0); // 이동
		if (result)
			sb.append("HaruHaru");
		else
			sb.append("Hing");
		System.out.println(sb);
	}

	static void go(int r, int c) {
		visited[r][c] = true; // 방문했다는 표시
		
		if (arr[r][c] == -1) { // 도달하면 출력
			result = true;
			return;
		}

		if (r + arr[r][c] < N && !visited[r + arr[r][c]][c]) { // r방향 이동
			go(r + arr[r][c], c);
		}
		if (c + arr[r][c] < N && !visited[r][c+arr[r][c]]) { // c방향 이동
			go(r, c + arr[r][c]);
		}

	}
}
