import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class psy_2117_홈 {
	static class House {
		int r;
		int c;
		int count;

		public House(int r, int c, int count) {
			this.r = r;
			this.c = c;
			this.count = count;
		}

	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int tc = Integer.parseInt(br.readLine());
		for (int i = 1; i <= tc; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			int[][] arr = new int[N][N];
			for (int r = 0; r < N; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < N; c++) {
					arr[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			int max = 0;
			out : for (int j = 1; j < N+2; j++) {
				int price = j * j + (j - 1) * (j - 1);
				boolean flag = false;
				for (int r = 0; r < N; r++) {
					for (int c = 0; c < N; c++) {
						int result = -1;
						Queue<House> q = new LinkedList<>();
						q.add(new House(r, c, j));
						boolean[][] visited = new boolean[N][N];
						visited[r][c] = true;
						int count = 0;
						while (!q.isEmpty()) {
							int oldr = q.peek().r;
							int oldc = q.peek().c;
							int oldcount = q.poll().count - 1;
							
							if (arr[oldr][oldc] == 1)
								count++;

							if (oldcount != 0) {
								for (int d = 0; d < 4; d++) {
									int nr = oldr + dr[d];
									int nc = oldc + dc[d];
									if (nr >= 0 && nc >= 0 && nr < N && nc < N && !visited[nr][nc]) {
										visited[nr][nc] = true;
										q.add(new House(nr, nc, oldcount));
									}
								}
							}
						}
						if(count*M - price >= 0) {
							result = Math.max(result, count);
							max = Math.max(max, result);
							flag = true;
						}
						if(r == N-1 && c == N-1 && !flag)
							;
//							break out;
						else if(r == N-1 && c == N-1) {
							flag = false;
						}
					}
				}
			}
			System.out.println("#"+i+" "+max);
			

		}
	}
}
