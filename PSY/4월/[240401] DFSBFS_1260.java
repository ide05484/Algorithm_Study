import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class psy_1260_DFSBFS {
	static int[][] arr1; // dfs 배열
	static List<Integer>[] arr2; // bfs 배열
	static boolean[] visited1, visited2; // dfs,bfs 방문
	static int V; // 정점

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		V = sc.nextInt(); // 정점
		int E = sc.nextInt(); // 간선
		int start = sc.nextInt(); // 시작점
		arr1 = new int[V + 1][V + 1]; // 1부터 시작하니 +1
		arr2 = new ArrayList[V + 1]; // 배열 생성
		visited1 = new boolean[V + 1];
		visited2 = new boolean[V + 1];

		for (int i = 1; i <= V; i++) { // 초기화
			arr2[i] = new ArrayList<>();
		}

		for (int i = 0; i < E; i++) { // 연결된곳 1표시
			int a = sc.nextInt();
			int b = sc.nextInt();
			arr1[b][a] = arr1[a][b] = 1;
			arr2[a].add(b);
			arr2[b].add(a);
		}
		dfs(start); // dfs
		System.out.println();
		bfs(start); // bfs

	}

	static void bfs(int i) {
		Queue<Integer> queue = new LinkedList<>();

		visited2[i] = true; 
		queue.add(i);

		while (!queue.isEmpty()) {
			int a = queue.poll();
			System.out.print(a + " ");
			for (int j = 1; j <= V; j++) { // 숫자 작은 값부터 뽑기위해서 1부터 돌려주기
				for (int b : arr2[a]) {
					if (!visited2[b] && j == b) {
						queue.add(b);
						visited2[b] = true;
					}
				}
			}
		}
	}

	static void dfs(int i) {
		System.out.print(i + " ");
		visited1[i] = true;

		for (int j = 1; j <= V; j++) {
			if (arr1[i][j] == 1 && !visited1[j]) { // 다음곳 dfs 탐색
				dfs(j);
			}
		}
	}
}
