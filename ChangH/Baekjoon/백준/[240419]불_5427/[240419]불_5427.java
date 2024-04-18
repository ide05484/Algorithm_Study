package B5427;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {
	int r, c, t;

	public Node(int r, int c, int t) {
		this.r = r;
		this.c = c;
		this.t = t;
	}
}

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int T, W, H, starti, startj, result;
	static int[][] Map;
	static boolean[][] visited;
	static Queue<Node> qu;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		test();
	}

	private static void test() throws IOException {
		T = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= T; tc++) {
			testInput();
			testProcess();
			testOutput();
		}
	}

	private static void testInput() throws IOException {
		st = new StringTokenizer(br.readLine().trim());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		Map = new int[H][W];
		for (int i = 0; i < H; i++) {
			String tmp = br.readLine().trim();
			for (int j = 0; j < W; j++) {
				if (tmp.charAt(j) == '#') {
					Map[i][j] = -2;
				} else if (tmp.charAt(j) == '*') {
					Map[i][j] = 0;
				} else if (tmp.charAt(j) == '@') {
					starti = i;
					startj = j;
					Map[i][j] = -1;
				} else {
					Map[i][j] = -1;
				}
			}
		}
		result = 0;
		visited = new boolean[H][W];
		qu = new LinkedList<>();
	}

	private static void testProcess() {
		Node();
		move();
	}

	private static void Node() {

		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if (Map[i][j] == 0) {
					qu.add(new Node(i, j, 0));
				}
			}
		}

		while (!qu.isEmpty()) {
			Node fire = qu.poll();
			int r = fire.r;
			int c = fire.c;
			int t = fire.t;
			if (Map[r][c] != -1 && Map[r][c] != 0) 
				continue;
			Map[r][c] = t;

			for (int d = 0; d < 4; d++) {
				int newR = r + dr[d];
				int newC = c + dc[d];
				if (newR >= 0 && newR < H && newC >= 0 && newC < W && Map[newR][newC] == -1) {
					qu.add(new Node(newR, newC, t + 1));
				}
			}
		}
	}

	private static void move() {
		qu.clear();
		qu.add(new Node(starti, startj, 0));
		
		while(!qu.isEmpty()) {
			Node now = qu.poll();
			int r = now.r;
			int c = now.c;
			int t = now.t;
			if(visited[r][c]) continue;
			visited[r][c] = true;
			for(int d = 0; d<4; d++) {
				int newR = r+ dr[d];
				int newC = c+ dc[d];
				if(newR >= 0 && newR < H && newC >= 0 && newC < W) {
					if(!visited[newR][newC] && (Map[newR][newC] > t+1 || Map[newR][newC]== -1)) {
						qu.add(new Node(newR, newC, t+1));
					} 
				} else {
					result = t+1;
					return;
				}
			}
		}

	}

	private static void testOutput() {
		if(result != 0) {
			System.out.println(result);
		} else {
			System.out.println("IMPOSSIBLE");
		}
	}

}
