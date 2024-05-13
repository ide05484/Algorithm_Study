import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class psy_2583_영역구하기 {
	static class Node {
		int r;
		int c;

		public Node(int r, int c) {
			this.r = r;
			this.c = c;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int r = Integer.parseInt(st.nextToken()); // 가로
		int c = Integer.parseInt(st.nextToken()); // 세로 
		int k = Integer.parseInt(st.nextToken()); // 직사각형 갯수

		int[][] arr = new int[r][c]; // 배열 생성

		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int r1 = Integer.parseInt(st.nextToken());
			int c1 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());
			int c2 = Integer.parseInt(st.nextToken());
			for (int j = r1; j < r2; j++) {
				for (int l = c1; l < c2; l++) { // 직사각형 1로 채우기
					arr[l][j] = 1;
				}
			}
		}
		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };
		ArrayList<Integer> list = new ArrayList<>(); // 결과값 담을 배열 
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (arr[i][j] == 1) // 1이면 이미 잘린 부분이므로 패스
					continue;
				int count = 1; // 개수 세주기
				Queue<Node> queue = new LinkedList<>(); // bfs로 풀기
				queue.add(new Node(i, j));
				arr[i][j] = 1;
				while (!queue.isEmpty()) {
					int rrr = queue.peek().r;
					int ccc = queue.poll().c;
					for (int d = 0; d < 4; d++) {
						int nr = rrr + dr[d];
						int nc = ccc + dc[d];
						if (nr >= 0 && nc >= 0 && nr < r && nc < c && arr[nr][nc] == 0) {
							queue.add(new Node(nr, nc));
							arr[nr][nc] = 1;
							count++;
						}
					}
				}
				list.add(count);
			}
		}
		Collections.sort(list);
		System.out.println(list.size());
		for(int n : list)
			System.out.print(n+" ");
	}
}
