package B11724;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st; //입력 도구
	static int N, M; //무리의 수(및 출력), 간선의 갯수 
	static int[][] adj; //간선 목록
	static int[] p; //무리 관리자
	
	public static void main(String[] args) throws IOException {
		test();
	}

	private static void test() throws IOException {
		testInput(); //입력
		testProcess(); //실행
		testOutput(); //출력
	}

	private static void testInput() throws IOException {
		//초기화 및 입력
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		p = new int[N+1];
		adj = new int[M][2];
		for(int i =0 ; i< M; i++) {
			st = new StringTokenizer(br.readLine());
			adj[i][0] = Integer.parseInt(st.nextToken());
			adj[i][1] = Integer.parseInt(st.nextToken());
		}
		
	}

	private static void testProcess() {
		//무리 만들기, 초기에는 각자 도생
		for(int i = 1; i<=N; i++) {
			makeSet(i);
		}
		//간선의 갯수만큼 돌면서
		for(int k = 0 ; k < M; k++) {
			//대표자 확인
			int i = findSet(adj[k][0]);
			int j = findSet(adj[k][1]);
			//무리가 다르다면
			if(i!=j) {
				union(i, j); //합침
				N--; // 합쳐지면 총 무리의 수는 -1;
			}
		}
		
	}

	private static void makeSet(int i) {
		p[i] = i;
	}
	private static int findSet(int i) {
		if(p[i] == i) return i;
		return p[i] = findSet(p[i]);
	}
	private static void union(int i, int j) {
		p[j] = i;
	}

	private static void testOutput() {
		System.out.println(N); //출력
	}
}
