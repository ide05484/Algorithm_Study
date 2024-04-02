package DFS;

import java.util.Scanner;

public class 점프왕쩰리Large_16174 {
	
	static int N;
	static int dc[], dr[];
	static int field[][];
	static boolean visited[][];   

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		field = new int [N][N];
		visited = new boolean[N][N];
		
		// 입력부
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < N; c++) {
				field[r][c] = sc.nextInt();
			}
		}
	
		
		if(DFS(0,0)) {
			System.out.println("HaruHaru");
		} else {
			System.out.println("Hing");
		}
			
	}

	private static boolean DFS(int r, int c) {
		// 제자리, 좌, 하
		int[] dr = {0, 1};
		int[] dc = {1, 0};
		int length = field[r][c];
		
		// 방향 * 현재 자리의 값
		for(int i = 0; i < 2; i++) {
			int nr = r + dr[i] * length;
			int nc = c + dc[i] * length;
			
			// 유효범위 안이면서
			// 아직 방문 안했으면서
			// 0보다 큰 값이면
			if(nr >= 0 && nr < N && nc >= 0 && nc < N &&
					visited[nr][nc] == false && field[nr][nc] > 0) {				
				visited[nr][nc] = true;
				
				// DFS를 실행하는데
				// 만약 true가 반환되었으면 똑같이 true를 반환하라
				if(DFS(nr, nc)) return true;	
			}
			
			// 유효범위 안이면서
			// -1이면 true를 반환하라
			if(nr >= 0 && nr < N && nc >= 0 && nc < N &&
					field[nr][nc] == -1) {
				return true;
			}
			
		}
		
		// -1에 도달하지 않았다면 false를 반환하라
		return false;
		

		
	}

}
