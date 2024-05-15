package B2589;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class XY {
	int r, c, dist;

	public XY(int r, int c, int dist) {
		this.r = r;
		this.c = c;
		this.dist = dist;
	}

}

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int H, W, result;
	static String[] Map;
	static Queue<XY> pq = new LinkedList<>();
	static boolean[][] visited;
	static final int[] dr = { -1, 1, 0, 0 };
	static final int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		test();
	}

	private static void test() throws IOException {
		testInput();
		testProcess();
		testOutput();
	}

	private static void testInput() throws IOException {
		st = new StringTokenizer(br.readLine().trim());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		Map = new String[H];
		for (int i = 0; i < H; i++) {
			Map[i] = br.readLine().trim();
		}
		result = 0;
	}

	private static void testProcess() {
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if (Map[i].charAt(j) == 'L') {
					visited = new boolean[H][W];
					result = Math.max(result, check(i, j));
				}
			}
		}
	}

	private static int check(int i, int j) {
		pq.offer(new XY(i, j, 0));
		int tmp = 0;
		while (!pq.isEmpty()) {
			XY xy = pq.poll();
			int r = xy.r;
			int c = xy.c;
			if (visited[r][c])
				continue;
			visited[r][c] = true;
			int dist = xy.dist;
			tmp = Math.max(dist, tmp);
			for (int d = 0; d < 4; d++) {
				int newr = r + dr[d];
				int newc = c + dc[d];
				if (newr >= 0 && newr < H && newc >= 0 && newc < W && !visited[newr][newc]
						&& Map[newr].charAt(newc) == 'L') {
					pq.add(new XY(newr, newc, dist + 1));
				}
			}
		}
		return tmp;
	}

	private static void testOutput() {
		System.out.println(result);
	}
}
