package DFS;
import java.util.Scanner;

public class 연결요소의개수_11724 {

	static int V, E, count;
	static int[][] adj;
	static boolean[] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		V = sc.nextInt();
		E = sc.nextInt();
		
		adj = new int [V+1][V+1];
		visited = new boolean[V+1];
		
		for(int i = 0; i < E; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			
			adj[A][B] = adj[B][A] = 1;
		}

		// 모든 visited 경우에 관해 DFS 실행, DFS가 실행되는 만큼 count
		for(int i = 1; i <= V; i++) {
			if(visited[i]==false) {
				DFS(i);
				count++;
			}
		}
		
		System.out.println(count);
	}

	private static void DFS(int start) {
		visited[start] = true;
		//System.out.print(start + " ");
		
		for(int i = 1; i <= V; i++) {
			if(visited[i]==false && adj[start][i]==1) {
				DFS(i);
			}
		}
		
		
	}
}
