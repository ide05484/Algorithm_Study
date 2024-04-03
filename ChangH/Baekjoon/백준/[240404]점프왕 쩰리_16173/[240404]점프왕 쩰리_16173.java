package B16173;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	//입출력 도구
	static int N;
	static int[][] map;
	static boolean[][] visited;
	static boolean canWin;
	//변수 및 데이터
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
		map = new int[N][N];
		for(int i = 0; i< N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		visited = new boolean[N][N];
		//초기화 및 데이터 입력
	}
	private static void testProcess() {
		canWin = dfs(0, 0);
		//승리 여부, 시작점에서 DFS 탐색
	}
	private static boolean dfs(int i, int j) {
		//도착지면 승리 출력
		if(map[i][j]==-1) {
			return true;
		}
		//방문한 곳이면 리턴
		if(visited[i][j]) return false;
		visited[i][j] = true;
		
		//우측과 아래로만 이동 가능 아래부터 탐색
		if(i+map[i][j] <N) {
			if(dfs(i+map[i][j], j)) { //승리 가능한 도착지면
				return true; // 승리 리턴 반복
			}
		} 
		if(j+map[i][j] <N) {
			if(dfs(i, j+map[i][j])) {
				return true; //승리 가능한 도착지면 승리 리턴 반복
			}
		}
		
		return false; //가망 없음
	}
	private static void testOutput() {
		if(canWin) {
			System.out.println("HaruHaru");
		} else {
			System.out.println("Hing");
		}
	}
	
}
