import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class psy_2589_보물섬 {
	static class Miro {
		int r;
		int c;
		int count;

		public Miro(int r, int c, int count) {
			super();
			this.r = r;
			this.c = c;
			this.count = count;
		}
	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int h = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());

		char[][] arr = new char[h][w];

		for (int r = 0; r < h; r++) {
			String str = br.readLine();
			for (int c = 0; c < w; c++) {
				arr[r][c] = str.charAt(c);
			}
		}

		Queue<Miro> q = new LinkedList<>();

		int result = 0;
		for (int r = 0; r < h; r++) {
			for (int c = 0; c < w; c++) {
				int max = 0;
				if (arr[r][c] == 'L') {
					boolean[][] visitedFire = new boolean[h][w];
					q.add(new Miro(r, c, 0));
					visitedFire[r][c] = true;
					while (!q.isEmpty()) {
						int bomulR = q.peek().r;
						int bomulC = q.peek().c;
						int count = q.poll().count;

						for (int d = 0; d < 4; d++) {
							int nr = bomulR + dr[d];
							int nc = bomulC + dc[d];
							if (nr >= 0 && nc >= 0 && nr < h && nc < w && !visitedFire[nr][nc]) {
								visitedFire[nr][nc] = true;
								if (arr[nr][nc] == 'L')
									q.add(new Miro(nr, nc, count + 1));
							}
						}
						max = Math.max(max, count);
					}

					result = Math.max(max, result);
				}
			}

		}
		System.out.println(result);
	}
}
