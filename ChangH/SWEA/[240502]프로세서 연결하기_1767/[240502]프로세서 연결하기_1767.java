package S1767;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	//입력 도구
	static int T, N, maxCore, minWireLine;
	static List<Point> coreList;
	static int[][] Map;
	static boolean[][] checkCrossConnection;
	//처리 도구
	static final int INF = 987654321;
	static final int[] dr = {-1, 1, 0, 0};
	static final int[] dc = {0, 0, -1, 1};
	//기본 데이터
	static StringBuilder result = new StringBuilder();
	//출력 도구
	
	public static void main(String[] args) throws IOException {
		test(); //테스트
	}

	private static void test() throws IOException {
		T = Integer.parseInt(br.readLine().trim()); // 테케 수만큼
		for(int tc = 1; tc<= T; tc++) { 
			testInput(); //입력
			testProcess(tc); //처리
		}
		testOutput(); //최종 출력
	}

	private static void testInput() throws IOException {
		N = Integer.parseInt(br.readLine().trim()); 
		Map = new int[N][N];
		checkCrossConnection = new boolean[N][N]; 
		coreList= new ArrayList<>();
		for(int i = 0 ; i<N; i++) { 
			st = new StringTokenizer(br.readLine().trim());
			for(int j = 0 ; j<N; j++) {
				Map[i][j] = Integer.parseInt(st.nextToken());
				if(Map[i][j] == 1) {
					coreList.add(new Point(i, j));
					checkCrossConnection[i][j] = true;
				}
			}
		}
		maxCore = 0; minWireLine = INF;
		//데이터 입력 및 초기화
	}

	private static void testProcess(int tc) {
		dfs(0, 0, 0); //dfs 탐색
		result.append("#" + tc + " " + minWireLine + "\n"); //출력값 출력 도구에 저장
	}

	private static void dfs(int nowCoreidx, int nowConnect, int nowWireDist) {
		if(nowCoreidx>=coreList.size()) { //코어 탐색이 끝났다면
			if(nowConnect>maxCore) {
				maxCore = nowConnect;
				minWireLine = nowWireDist;
			} else if(maxCore==nowConnect) {
				minWireLine = Math.min(minWireLine, nowWireDist);
			}
			return;
		}
		Point nowCore = coreList.get(nowCoreidx); //현재 코어
		int px = nowCore.x; int py = nowCore.y;
		if(px==0 || px==N-1 || py == 0 || py == N-1) { //경계값이면
			dfs(nowCoreidx+1, nowConnect+1, nowWireDist); //항상 연결상태로 보겠다.
		} else {
			dfs(nowCoreidx+1, nowConnect, nowWireDist); //연결하지 않고 넘어갔을 경우 탐색
			for(int d= 0; d<4; d++) {
				int nx = px; int ny = py; //방향마다 돌면서
				for(int i = 0 ; i<=N; i++) {
					nx += dr[d]; //이동 후
					ny += dc[d];
					if(nx>=0 && nx<N && ny >=0 && ny<N) {
						if(!checkCrossConnection[nx][ny]) { //경로에 문제가 없으면 경로 지나갔다고 표시
							checkCrossConnection[nx][ny] = true;
						} else { //경로 문제 생기면 전선 회수
							returnBack(nx, ny, d, i);
							break;
						}
					} else { //경계 밖이면 연결 성공했고, 전선 합 저장후 DFS, 이후 전선 회수
						dfs(nowCoreidx+1, nowConnect+1, nowWireDist+i);
						returnBack(nx, ny, d, i);
						break;
					}
				}
			}
		}
	}

	private static void returnBack(int x, int y, int nd, int dist) {
		int d; int nx = x; int ny = y; //변수 초기화
		if(nd%2==1) d = nd-1; //방향 역방향으로 전환
		else d = nd+1;
		
		for(int i= 0; i<dist; i++) { //뒤돌아서 기존 전선 회수
			nx += dr[d];
			ny += dc[d];
			checkCrossConnection[nx][ny] = false;
		}
	}

	private static void testOutput() {
		System.out.println(result);
	}
}
