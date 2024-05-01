import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class psy_1767_프로세서 {
	static class Process {
		int r;
		int c;

		public Process(int r, int c) {
			this.r = r;
			this.c = c;
		}

	}

	static List<Process> list;
	static Map<Integer, Integer> result;
	static int N;
	static int[] dc = { -1, 1, 0, 0 };
	static int[] dr = { 0, 0, -1, 1 };
	static int connect;
	static int len;
	static int count;
	static boolean checked[][];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int tc = Integer.parseInt(br.readLine());
		for (int i = 1; i <= tc; i++) {
			N = Integer.parseInt(br.readLine());
			int[][] arr = new int[N][N];

			list = new ArrayList<>();
			checked = new boolean[N][N];
			for (int r = 0; r < N; r++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int c = 0; c < N; c++) {
					arr[r][c] = Integer.parseInt(st.nextToken());
					if (arr[r][c] == 1) {
						list.add(new Process(r, c));
						checked[r][c] = true;
					}
				}
			}
			result = new HashMap<>();
			dfs(0);
			connect = 0;
				System.out.print(result.toString()+" ");
		}
	}

	static void dfs(int i) {
		if (i == list.size()) {
			result.put(connect, count);
			return;
		}

		if (list.get(i).r == 0 || list.get(i).c == 0 || list.get(i).r == N - 1 || list.get(i).c == N - 1) {
			connect++;
			dfs(i + 1);
			connect--;
		} else {
			for (int d = 0; d < 4; d++) {
				int nr = list.get(i).r + dr[d];
				int nc = list.get(i).c + dc[d];

				if (nr == 0 || nc == 0 || nr == N - 1 || nc == N - 1 && !checked[nr][nc]) {
					connect++;
					checked[nr][nc] = true;
					dfs(i + 1);
					connect--;
					checked[nr][nc] = false;
				} else if (!checked[nr][nc]) {
					checked[nr][nc] = true;
					count++;
					while (true) {
						nr += dr[d];
						nc += dc[d];
						if (nr == 0 || nc == 0 || nr == N - 1 || nc == N - 1 && !checked[nr][nc]) {
							checked[nr][nc] = true;
							count++;
							connect++;
							dfs(i + 1);
							connect--;
							while (true) {
								count--;
								checked[nr][nc] = false;
								nr -= dr[d];
								nc -= dc[d];
								if (nr == list.get(i).r && nc == list.get(i).c)
									break;
							}
							break;
						}
						if (checked[nr][nc]) {
							while (true) {
								nr -= dr[d];
								nc -= dc[d];
								checked[nr][nc] = false;
								count--;
								if (nr == list.get(i).r && nc == list.get(i).c)
									break;
							}
							dfs(i + 1);
						}else {
							checked[nr][nc] = true;
							count++;
						}
					}
					checked[nr][nc] = false;
					count--;
				} else {
					dfs(i + 1);
				}

			}
		}
	}
}
