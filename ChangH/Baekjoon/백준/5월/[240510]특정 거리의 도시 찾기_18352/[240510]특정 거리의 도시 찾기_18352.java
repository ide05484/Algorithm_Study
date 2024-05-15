package B18352;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	//입력 도구
	static int N, M, K, X; //도시 //도로 //거리 //시작
	static Map<Integer, List<Integer>> edges; //도로관계
	static boolean[] visited; //방문여부
	static PriorityQueue<Point> pq = new PriorityQueue<>(new Comparator<Point>() {
		public int compare(Point o1, Point o2) {
			return o1.y - o2.y;
		};
	}); //x= 도시, y는 현재 거리
	//처리 도구	
	static List<Integer> resultList = new ArrayList<>(); 
	static StringBuilder result = new StringBuilder();
	//출력 도구
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
		K = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		edges = new HashMap<>();
		visited = new boolean[N+1];
		for(int i = 0 ; i<M; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(!edges.containsKey(a))
				edges.put(a, new ArrayList<>());
			edges.get(a).add(b);
		}
		//데이터 초기화 및 입력
	}
	private static void testProcess() {
		pq.add(new Point(X, 0));
		while(!pq.isEmpty()) {
			Point p = pq.poll();
			int x = p.x;
			int dist = p.y;
			if(visited[x]) continue;
			visited[x] = true;
			if(dist == K) { // 이 과정에서 K 넘어가는 도시는 바로 건너뜀
				resultList.add(x);
				continue;
			}
			if(edges.containsKey(x)) {
				for(int y: edges.get(x)) {
					if(!visited[y]) {
						pq.add(new Point(y, dist+1));
					}
				}
			}
		}
		if(resultList.isEmpty()) {
			result.append(-1); 
		} else {
			Collections.sort(resultList);
			for(int i = 0 ; i<resultList.size(); i++) {
				result.append(resultList.get(i) + "\n");
			}
		}
		
		
	}
	private static void testOutput() {
		System.out.println(result);
	}
}
