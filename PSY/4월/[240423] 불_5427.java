import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class psy_5427_불 {
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

		int tc = Integer.parseInt(br.readLine());

		for (int i = 0; i < tc; i++) {

			StringTokenizer st = new StringTokenizer(br.readLine());

			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());

			char[][] arr = new char[h][w];

			Queue<Miro> sang = new LinkedList<>();
			Queue<Miro> fire = new LinkedList<>();
			for (int r = 0; r < h; r++) {
				String str = br.readLine();
				for (int c = 0; c < w; c++) {
					arr[r][c] = str.charAt(c);
					if (arr[r][c] == '@')
						sang.add(new Miro(r, c, 1));
					else if (arr[r][c] == '*')
						fire.add(new Miro(r, c, 1));
				}
			}
			int[][] firemap = new int[h][w];
			boolean[][] visitedFire = new boolean[h][w];
			boolean[][] visitedSang = new boolean[h][w];
			while (!fire.isEmpty()) {
				int fireR = fire.peek().r;
				int fireC = fire.peek().c;
				int count = fire.poll().count;
				for (int d = 0; d < 4; d++) {
					int nr = fireR + dr[d];
					int nc = fireC + dc[d];
					if (nr >= 0 && nc >= 0 && nr < h && nc < w && !visitedFire[nr][nc]) {
						visitedFire[nr][nc] = true;
						if (arr[nr][nc] == '.' || arr[nr][nc] == '@')
							fire.add(new Miro(nr, nc, count + 1));
					}
				}
				firemap[fireR][fireC] = count;
			}
			for(int r = 0; r < h; r++) {
				for(int c = 0; c < w; c++) {
					if(firemap[r][c] == 0)
						firemap[r][c] = 10000;
				}
			}
			
			int min = Integer.MAX_VALUE;
			while (true) {
				int sangR = sang.peek().r;
				int sangC = sang.peek().c;
				int count = sang.poll().count;
				for (int d = 0; d < 4; d++) {
					int nr = sangR + dr[d];
					int nc = sangC + dc[d];
					if (nr >= 0 && nc >= 0 && nr < h && nc < w && !visitedSang[nr][nc]) {
						visitedSang[nr][nc] = true;
						if (arr[nr][nc] == '.' && count + 1 < firemap[nr][nc])
							sang.add(new Miro(nr, nc, count + 1));
					}
				}
				if (sangR == 0 || sangC == 0 || sangR == h - 1 || sangC == w - 1)
					min = Math.min(min, count);
				if (sang.isEmpty()) {
					if (min == Integer.MAX_VALUE)
						System.out.println("IMPOSSIBLE");
					else
						System.out.println(min);
					break;
				}
			}
		}
	}
}
