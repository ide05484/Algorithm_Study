import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 효율적인해킹_1325 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 총 컴퓨터수
		int M = Integer.parseInt(st.nextToken()); // 주어지는 신뢰관계 수

		List<Integer> list[] = new LinkedList[N + 1]; // 그래프 연결리스트로 연결

		for (int m = 1; m <= N; m++) {
			list[m] = new LinkedList<>(); // 초기화해주는거
		}

		for (int m = 1; m <= M; m++) {
			st = new StringTokenizer(br.readLine());

			// 간선연결
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			list[start].add(end); //단방향임 ㅋ 
		} // 입력완

		Queue<Integer> queue = new LinkedList<>(); // BFS 하기로 함
		
		int[] answer = new int[N + 1]; // 정답배열

		for (int c = 1; c <= N; c++) {

			boolean[] visit = new boolean[N + 1]; // 컴퓨터 배열 방문체크
			// 시작하는 컴퓨터 번호수
			queue.add(c); // 첫 컴퓨터 넣고
			visit[c] = true;

			while (!queue.isEmpty()) {
				int curr = queue.poll(); // 지굼꺼내

				for (int j : list[curr]) {
					if (!visit[j]) {
						// 거기있는 곳이 방문한게 아니라면
						queue.add(j);
						answer[j]++; // 하나씩 더해더해
						visit[j] = true;
					}
				}
			} // BFS 끝
		} // 모든 컴퓨터를 돌았다

		int max = 0;

		for (int i = 1; i <= N; i++) {
			max = Math.max(max, answer[i]);
		}

		StringBuilder sb = new StringBuilder();

		for (int com = 1; com <= N; com++) {
			if (answer[com] == max)
				sb.append(com + " ");
		}

		System.out.println(sb);
	}
}
