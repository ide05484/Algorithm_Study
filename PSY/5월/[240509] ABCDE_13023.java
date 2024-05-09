import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class psy_13023_ABCDE {
	static int N, M;
	static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
	static boolean[] visited;
	static boolean result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 사람수
		M = Integer.parseInt(st.nextToken()); // 관계 수
		visited = new boolean[N]; // 방문했는지 체크

		for (int i = 0; i < N; i++)
			list.add(new ArrayList<>()); // 초기화

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()); 
			int b = Integer.parseInt(st.nextToken());
			list.get(a).add(b); // 친구관계 양방향이랑 둘다 추가
			list.get(b).add(a);
		}

		for (int i = 0; i < N; i++) // 모든 사람 시작점으로 dfs돌기
			dfs(0, i);

		System.out.println(result ? 1 : 0); // 존재시 1 아니면 0
	}

	private static void dfs(int cnt, int n) {
		if(result) // 이미 존재하면 더 돌 필요 없음
			return;
		if (cnt == 4) { // 조건 만족시 리턴
			result = true;
			return;
		}
		visited[n] = true; // 방문 체크
		for (int i = 0; i < list.get(n).size(); i++) { // 현재 사람의 친구 모두 순회
			if (!visited[list.get(n).get(i)])
				dfs(cnt + 1, list.get(n).get(i));

		}
		visited[n] = false;
	}
}
