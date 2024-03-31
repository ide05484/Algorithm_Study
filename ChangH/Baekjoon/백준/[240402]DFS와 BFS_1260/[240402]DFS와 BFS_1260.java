package B1260;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder result = new StringBuilder();
	static int N, M, V;
	static boolean[][] adj;
	static boolean[] dfs, bfs;
	
	public static void main(String[] args) throws IOException {
		test();
	}

	private static void test() throws IOException {
		testInput();
		testProcess();
		testOutput();
	}

	private static void testInput() throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		adj = new boolean[N+1][N+1];
		dfs = new boolean[N+1];
		bfs = new boolean[N+1];
		for(int i = 0; i< M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			adj[a][b] = adj[b][a] = true;
		}
	}

	private static void testProcess() {
		dfs(V);
		result.append("\n");
		bfs(V);
	}

	private static void dfs(int v) {
		if(dfs[v]) return;
		dfs[v] = true;
		result.append(v+" ");
		for(int i = 1 ; i<=N; i++) {
			if(adj[v][i]) {
				dfs(i);
			}
		}
	}

	private static void bfs(int v) {
		Queue<Integer> q = new LinkedList<>();
		q.add(v);
		while(!q.isEmpty()) {
			int node = q.poll();
			if(bfs[node]) continue;
			bfs[node] = true;
			result.append(node + " ");
			for(int i = 1; i<= N; i++) {
				if(adj[node][i]) {
					q.add(i);
				}
			}
		}
	}

	private static void testOutput() {
		System.out.println(result.toString());
	}
	
	
	
}
