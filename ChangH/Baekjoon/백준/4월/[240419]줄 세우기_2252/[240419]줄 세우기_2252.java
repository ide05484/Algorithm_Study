package B2252;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static Map<Integer, Set<Integer>> edges;
	static Queue<Integer> q = new LinkedList<>();
	static int N, M;
	static int[] cnt;
	
	static StringBuilder result = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		test();
	}

	private static void test() throws IOException {
		testInput();
		testProcess();
		testOutput();
	}

	private static void testInput() throws IOException {
		st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		edges = new HashMap<>();
		cnt = new int[N+1];
		for(int i = 0 ; i<M; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			if(!edges.containsKey(s)) {
				edges.put(s, new HashSet<>());
			}
			edges.get(s).add(e);
			cnt[e]++;
		}
	}

	private static void testProcess() {
		for(int i = 1; i<=N; i++) {
			if(cnt[i]==0) {
				q.add(i);
			}
		}
		while(!q.isEmpty()) {
			int s = q.poll();
			result.append(s+" ");
			if(edges.containsKey(s)) {
				for(int e:edges.get(s)) {
					cnt[e]--;
					if(cnt[e]==0) {
						q.add(e);
					}
				}
			}
		}
	}

	private static void testOutput() {
		System.out.println(result);
	}
	
}
