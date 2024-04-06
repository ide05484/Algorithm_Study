package B2667;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder result = new StringBuilder();
	//입출력 도구
	static int N; //데이터 사이즈
	static String[] field; //필드
	static boolean[][] visited; //방문여부
	static PriorityQueue<Integer> pq = new PriorityQueue<>(); //단지 내 가구 숫자 저장
	static int[] dr = {1, -1, 0, 0}; //델타
	static int[] dc = {0, 0, 1, -1};
	public static void main(String[] args) throws IOException {
		test();
	}
	private static void test() throws IOException {
		testInput();
		testProcess();
		testOutput();
	}
	private static void testInput() throws IOException {
		N = Integer.parseInt(br.readLine());
		field = new String[N];
		for(int i = 0 ; i<N; i++) {
			field[i] = br.readLine();
		}
		visited = new boolean[N][N];
		//초기화 및 데이터 입력
	}
	private static void testProcess() {
		//필드 돌면서 가구 있으면 주변 단지 확인
		for(int i = 0 ; i<N; i++) {
			for(int j = 0 ; j<N; j++) {
				if(field[i].charAt(j)=='1' && !visited[i][j]) {
					int tmp = dfs(i, j); //리턴값은 해당 단지 내 가구 수
					pq.add(tmp);
				}
			}
		}
		result.append(pq.size()+"\n");
		while(!pq.isEmpty()) {
			result.append(pq.poll()+"\n");
		}
	}
	private static int dfs(int i, int j) {
		if(visited[i][j]) return 0;
		visited[i][j] = true;
		
		int tmp = 1; //나 자신도 집임
		for(int d = 0; d<4; d++) {
			if(i+dr[d]>=0 && i+dr[d]<N && j+dc[d] >=0 && j+dc[d]<N && field[i+dr[d]].charAt(j+dc[d])=='1') {
				tmp += dfs(i+dr[d], j+dc[d]); // 주변 탐색
			}
			
		}
		return tmp; //최종적으로 주변 집
	}
	private static void testOutput() {
		System.out.println(result);
	}
	
}
