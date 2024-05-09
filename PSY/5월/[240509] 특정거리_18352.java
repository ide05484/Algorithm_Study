import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class psy_18352_특정거리 {
	static int N, M, K, X;
	static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
	static boolean[] visited;
	static ArrayList<Integer> result = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 사람수
		M = Integer.parseInt(st.nextToken()); // 관계 수
		K = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		visited = new boolean[N + 1]; // 방문했는지 체크

		for (int i = 0; i < N; i++)
			list.add(new ArrayList<>()); // 초기화

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list.get(a).add(b);
		}

		dfs(0, X);
		if (result.size() == 0)
			System.out.println(-1);
		else
			System.out.println(result);

	}

	private static void dfs(int cnt, int n) {

		if (cnt == K) { // 조건 만족시 리턴
			result.add(n);
			return;
		}
		visited[n] = true; // 방문 체크
		System.out.println(list.getClass() );
		for (int i = 0; i < list.get(n).size(); i++) { // 현재 사람의 친구 모두 순회
			if (!visited[list.get(n).get(i)])
				dfs(cnt + 1, list.get(n).get(i));

		}
		visited[n] = false;
	}
}
