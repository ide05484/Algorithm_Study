package DFS;
import java.util.Arrays;
import java.util.Scanner;

public class 단지번호붙이기_2667 {

	static int N, number;
	static int[] counting, counting2;
	static int[][] field;
	static boolean[][] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		number  = 0;
		field = new int [N][N];
		visited = new boolean[N][N];
		
		for(int r = 0; r < N; r++) {
			String temp = sc.next();
			for(int c = 0; c < N; c++) {
				field[r][c] = temp.charAt(c) - '0';
			}
		}
		
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < N; c++) {
				if(visited[r][c] == false && field[r][c] != 0) {
					number ++;
					DFS(r,c);
				}
			}
		}

		//단지 번호가 잘 들어갔는지 출력해서 확인
//		for(int r = 0; r < N; r++) {
//			for(int c = 0; c < N; c++) {
//				System.out.print(field[r][c]+"");
//			}
//			System.out.println();
//		}
		
		// counting 배열에서 0 제외
		// DFS로 단지수에 맞게 바뀐 값들을 counting 배열에 담아 각 단지별로 집의 수 구하기
		counting = new int [number];
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < N; c++) {
				// 0이 제외되도록 값의 -1 index에 저장되도록 함
				if(field[r][c] == 0) {
					continue;
				}
				counting[field[r][c] - 1]++;
			}
		}
		
		// 총 단지수 출력
		System.out.println(counting.length);
		
		// 각 단지내 집의 수 오름차순으로 정렬후 출력
		Arrays.sort(counting);
		for(int i = 0; i < counting.length; i++) {
			System.out.println(counting[i]);
		}
		
	}
	
	private static void DFS(int r, int c) {
		
		int[] dr = { 0, 1, -1, 0, 0 };
		int[] dc = { 0, 0, 0, -1, 1 };
		
		for (int i = 0; i < 5; i++) {

			int nr = r + dr[i];
			int nc = c + dc[i];

			if (nr >= 0 && nr < N && nc >= 0 && nc < N &&
					visited[nr][nc] == false && field[nr][nc] != 0) {
				visited[nr][nc] = true;
				field[nr][nc] = number ;
				DFS(nr, nc);
			}
		}
		
	}

}
