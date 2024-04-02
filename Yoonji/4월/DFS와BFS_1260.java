import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static int N, M, V; // 정점의 수, 간선의 수, 시작번호
	static int[][] adj; // 인접행렬
	static boolean[] visited; // 방문체크
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		V = sc.nextInt();
	   
		adj = new int[N + 1][N + 1]; // 시작정점이 1번부터 시작!
		visited = new boolean[N + 1];	
		
		for (int i = 0; i < M; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			adj[A][B] = adj[B][A] = 1; //인접행렬 (무향)
		} //간선 정보 입력 완료
		
		
		DFS(V);
		System.out.println();
		
		BFS(V);
	}

	private static void DFS(int v) {
		visited[v] = true;
		System.out.print(v + " ");
		
		//인접행렬 방문
		for(int i = 1; i<=N; i++) {
			if(!visited[i] && adj[v][i] == 1)
				// 방문하지 않았으면서, 인접이 있으면, DFS 동작
				DFS(i);
		}
		
	}
	
	private static void BFS(int v) {
		visited = new boolean[N + 1];
		
		Queue<Integer> queue = new LinkedList<>();
		
		queue.add(v); //시작정점을 큐에 넣는다. 
		visited[v] = true; //시작정점 방문처리한다.
		
		while(!queue.isEmpty()) {
			int curr = queue.poll(); //정점 하나를 꺼내!
			System.out.print(curr + " "); //경로 한번 찍어보기 
			
			// 인접행렬
			for (int i = 1; i <= N; i++) {
				if (adj[curr][i] == 1 && !visited[i]) {
					//인접하면서, 방문하지 않았으면 Queue에 넣는다
					queue.add(i);
					visited[i] = true; // 미리 방문처리를 해서 중복으로 큐에 넣는 것 방지
				}
			}
		}
		
	}
}