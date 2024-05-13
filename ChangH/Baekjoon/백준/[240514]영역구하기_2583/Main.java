package B2583;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	//입력 도구
	
	static int M, N, K;
	static boolean[][] paper;
	static List<Integer> list;
	//변수 데이터
	
	static int[] dr = {1, -1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	//처리 도구
	
	static StringBuilder result = new StringBuilder();
	//출력 도구
	
	public static void main(String[] args) throws IOException {
		test();
	}

	private static void test() throws IOException {
		
		st = new StringTokenizer(br.readLine().trim());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		paper = new boolean[N][M];
		list = new ArrayList<>();
		//변수 초기화
		
		for(int i = 0 ; i<K; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			for(int x = a; x<c; x++) {
				for(int y = b; y<d; y++) {
					paper[x][y] = true;
				}
			}
		}
		//데이터 처리
		
		for(int i = 0; i<N; i++) {
			for(int j = 0 ; j<M; j++) {
				if(!paper[i][j]) {
					list.add(dfs(i, j));
				}
			}
		}
		//영역 탐색
		
		Collections.sort(list);
		result.append(list.size()).append("\n");
		for(int i = 0 ;i < list.size(); i++) {
			result.append(list.get(i)).append(" ");
		}
		System.out.println(result);
		//출력
	}

	private static int dfs(int i, int j) {
		int tmp = 1; // 기본 1
		paper[i][j] = true; // 방문 처리
		for(int d = 0; d<4; d++) {
			int r = i+dr[d];
			int c = j+dc[d];
			if(r>=0 && r<N && c>=0 && c<M && !paper[r][c]) {
				tmp += dfs(r, c);
			} //방문 안한곳 dfs 돌면서 결과값 가져오기
		}
		return tmp; //반환
	}
}
