package B31427;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

class Key {
	String key;

	public Key(String key) {
		super();
		this.key = key;
	}

	@Override
	public int hashCode() {
		return Objects.hash(key.charAt(0));
	}

	@Override
	public boolean equals(Object obj) {
		
		Key other = (Key) obj;
		
		for(int i = 0 ; i < Math.min(this.key.length(), other.key.length()); i++) {
			if(this.key.charAt(i) != other.key.charAt(i)) {
				return false;
			}
		}
		return true;
	}
	
	
}

class Edge {
	int st, ed;

	public Edge(int st, int ed) {
		this.st = st;
		this.ed = ed;
	}
	
}

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	// 입출력 도구
	static int N, M, Q; // 정점의 갯수, 도로의 갯수, 관리비 변동 횟수
	static Map<Integer, Set<Edge>> edge = new HashMap<>(); // 관리비 주체, 간선 집합
	static PriorityQueue<Integer> pq; // 우선순위 큐
	static long result; // 결과
	static Map<Key, int[]> dpTable = new HashMap<>();
	static int[] cost; // 관리비 변동기록
	static int[] P; // 정점 관리

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
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());

		// 관리비 주체에 따라서 도로 관리
		for (int i = 0; i < 5; i++) {
			edge.put(i, new HashSet<>());
		}
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int widx = st.nextToken().charAt(0) - 'A';
			edge.get(widx).add(new Edge(A, B));

		}

		cost = new int[5];
		P = new int[N + 1];
		// 데이터 입력과 초기화
	}

	private static void testProcess() throws IOException {
		madedp(); //모든 경우의 수 저장
		for (int i = 0; i < Q; i++) {
			// 현재 비용을 코스트 기록에 저장함
			st = new StringTokenizer(br.readLine().trim());
			cost[0] = Integer.parseInt(st.nextToken());
			cost[1] = Integer.parseInt(st.nextToken());
			cost[2] = Integer.parseInt(st.nextToken());
			cost[3] = Integer.parseInt(st.nextToken());
			cost[4] = Integer.parseInt(st.nextToken());
			result = 0;
			// 코스트를 기준으로 배열 정렬
			pq = new PriorityQueue<>(new Comparator<Integer>() {

				@Override
				public int compare(Integer o1, Integer o2) {
					// 코스트가 낮은 순으로 정렬하되, 같을 경우에는 항상 같게 정렬되도록 인덱스 기준으로 정렬함
					if (cost[o1] == cost[o2]) {
						return o1 - o2;
					}
					return cost[o1] - cost[o2];
				}

			});
			for (int j = 0; j < 5; j++) {
				pq.add(j);
			}
			// 코스트를 기준으로 키 생성
			int[] nowCost = new int[5];
			String key = "";
			for (int j = 0; j < 5; j++) {
				nowCost[j] = pq.poll();
				key += nowCost[j];
			}
			// 키를 기반으로 dp에서 사용된 도로의 갯수 가져오기

			int[] now = dpTable.get(new Key(key));

			// 결과값 계산
			for (int j = 0; j < now.length; j++) {
				result += ((long) cost[nowCost[j]]) * now[j];
			}
			sb.append(result + "\n");
		}
	}

	private static int[] madedp() {
		int[][] backUpP = new int[5][N + 1];
		for (int j = 1; j <= N; j++) {
			make(j);
		}
		int[] newMemo = new int[5];
		boolean[] visited = new boolean[5];
		int cnt = 0;
		int tmp;
		// 초기화 및 관리비 적은 순대로 나열, 관리비가 적은 간선부터 뽑아서 크루스칼
		// 각 단계별로 완성되면 키로 저장하고, 다음 것으로 이동;
		
		for (int i = 0; i < 5; i++) {
			System.arraycopy(P, 1, backUpP[0], 1, N);
			visited[i] = true;
			newMemo[0] = makeEdge(i);
			cnt += newMemo[0];
			if (cnt != N - 1) {
				for (int j = 0; j < 5; j++) {
					if (visited[j])
						continue;
					System.arraycopy(P, 1, backUpP[1], 1, N);
					visited[j] = true;
					newMemo[1] = makeEdge(j);
					cnt += newMemo[1];
					if (cnt != N - 1) {
						for (int k = 0; k < 5; k++) {
							if (visited[k])
								continue;
							System.arraycopy(P, 1, backUpP[2], 1, N);
							visited[k] = true;
							newMemo[2] = makeEdge(k);
							cnt += newMemo[2];
							if (cnt != N - 1) {
								for (int l = 0; l < 5; l++) {
									if (visited[l])
										continue;
									System.arraycopy(P, 1, backUpP[3], 1, N);
									visited[l] = true;
									newMemo[3] = makeEdge(l);
									cnt += newMemo[3];
									if (cnt != N - 1) {
										for (int d = 0; d < 5; d++) {
											if (visited[d])
												continue;
											System.arraycopy(P, 1, backUpP[4], 1, N);
											newMemo[4] = makeEdge(d);

											int[] tmparr = new int[5];
											System.arraycopy(newMemo, 0, tmparr, 0, 5);
											String key = i + "" + j + "" + k + "" + l + "" + d;
											dpTable.put(new Key(key), tmparr);

											System.arraycopy(backUpP[4], 1, P, 1, N);
										}

									} else {
										int[] tmparr = new int[4];
										System.arraycopy(newMemo, 0, tmparr, 0, 4);
										String key = i + "" + j+"" +k + ""+l;
										dpTable.put(new Key(key), tmparr);
									}
									cnt -= newMemo[3];
									System.arraycopy(backUpP[3], 1, P, 1, N);
									visited[l] = false;

								}

							} else {
								int[] tmparr = new int[3];
								System.arraycopy(newMemo, 0, tmparr, 0, 3);
								String key = i + "" + j+"" +k;
								dpTable.put(new Key(key), tmparr);
							}
							cnt -= newMemo[2];
							System.arraycopy(backUpP[2], 1, P, 1, N);
							visited[k] = false;
						}
					} else {
						int[] tmparr = new int[2];
						System.arraycopy(newMemo, 0, tmparr, 0, 2);
						String key = i + "" + j;
						dpTable.put(new Key(key), tmparr);
					}
					cnt -= newMemo[1];
					System.arraycopy(backUpP[1], 1, P, 1, N);
					visited[j] = false;
				}
			} else {
				int[] tmparr = new int[1];
				System.arraycopy(newMemo, 0, tmparr, 0, 1);
				String key = i + "";
				dpTable.put(new Key(key), tmparr);
			}
			cnt -= newMemo[0];
			System.arraycopy(backUpP[0], 1, P, 1, N);
			visited[i] = false;
		}
		return newMemo;
	}

	private static int makeEdge(int idx) {
		int tmp = 0;
		for (Edge e : edge.get(idx)) {
			int start = find(e.st);
			int end = find(e.ed);
			if (start == end) { // 연결 여부 검사
				continue;
			}
			union(start, end);
			tmp++;
		}
		return tmp;
	}

	// 집합 관리
	private static void make(int j) {
		P[j] = j;
	}

	// 집합 대표 찾으면서 경로 압축
	private static int find(int x) {
		if (P[x] == x) {
			return x;
		}
		return P[x] = find(P[x]);
	}

	// 대표 변경
	private static void union(int x, int y) {
		P[y] = x;
	}

	// 결과값 출력
	private static void testOutput() {
		System.out.println(sb);
	}

}