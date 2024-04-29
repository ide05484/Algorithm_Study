package S2117;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    //입력 도구
    static int T, N, M, maxHome, allHome; //총 테스트케이스 수, 도시 크기, 집당 비용, 최대 서비스 가능 집, 총 집수(비용)
    static int[][] map; //도시
    static boolean[][] visited; //방문
    static Set<Point> l1, l2; //방문
    //처리 도구
    static int[] dr = {-1, 1, 0, 0}; //상 하 좌 우
    static int[] dc = {0, 0, -1, 1};
    //데이터 세팅
    static StringBuilder result = new StringBuilder();
    //출력 도구
    public static void main(String[] args) throws IOException {
        test(); //테스트
    }
    private static void test() throws IOException {
        T = Integer.parseInt(br.readLine().trim());
        for(int tc = 1 ; tc<= T; tc++) {
            testInput(); //케이스별 입력
            testProcess(tc); // 처리
        }
        testOutput(); //출력
    }

    private static void testInput() throws IOException {
        st = new StringTokenizer(br.readLine().trim());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        allHome = 0;
        maxHome = 0;
        for(int i = 0 ; i<N; i++) {
            st = new StringTokenizer(br.readLine().trim());
            for(int j = 0 ; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==1) {
                	allHome++;
                }
            }
        }
        allHome*=M;
        l1 = new HashSet<>();
        l2 = new HashSet<>();
        //데이터 입력 및 도구 초기화;
    }

    private static void testProcess(int tc) {
        for(int i = 0; i<N; i++) {
            for(int j = 0; j<N; j++) {
                visited = new boolean[N][N];
                bfs(i, j); // 각 좌표마다 BFS 
            }
        }
        result.append("#" + tc + " " + maxHome + "\n");
    }

    private static void bfs(int a, int b) {
        int tmp = 1; //현재 범위
        int tmp1 = 0; //현재 비용;
        int tmp2 = 0; //현재 수익 겸 집 갯수;
        l1.clear();
        l2.clear();
        l1.add(new Point(a, b));
        while(tmp1<=allHome) { // 총비용보다 높아지면 의미 없음
        	tmp1 = tmp * tmp + (tmp-1) * (tmp-1);
        	for(Point nowP: l1) {
        		int x = nowP.x;
        		int y = nowP.y;
        		if(visited[x][y]) continue;
        		visited[x][y]= true;
        		if(map[x][y] >0) {
        			tmp2++;
        		}
        		for(int d = 0 ; d<4; d++) {
        			int nx = x + dr[d];
        			int ny = y + dc[d];
        			if(nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny]) {
        				l2.add(new Point(nx,ny));
        			}
        		}
        	}
        	//매 사이클 마다 점검
        	if(tmp1 <= tmp2*M) {
        		maxHome = Math.max(maxHome, tmp2);
        	}
        	l1.clear();
        	l1.addAll(l2);
        	l2.clear();
        	tmp++;
        	
        }
        
    }

    private static void testOutput() {
        System.out.println(result);
    }
}
