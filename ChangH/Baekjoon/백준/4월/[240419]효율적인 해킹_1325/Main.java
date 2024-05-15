package B1325;

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
    
    static int N, M, nowMax;
	static Map<Integer, Set<Integer>> edges;
    static boolean[] visited;
    static int[] canHackingCnt;
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
        for(int i =0 ; i<M; i++) {
            st = new StringTokenizer(br.readLine().trim());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            if(!edges.containsKey(s)) {
            	edges.put(s, new HashSet<>());
            }
            edges.get(s).add(e);
        }
        canHackingCnt = new int[N+1];
        nowMax = 0;
    }

    private static void testProcess() {
        for(int i = 1; i<=N; i++) {
            visited = new boolean[N+1];
            check(i);
        }
        for(int i = 1; i<=N; i++) {
        	nowMax = Math.max(nowMax, canHackingCnt[i]);
        }
        for(int i = 1; i<=N; i++) {
        	if(canHackingCnt[i] == nowMax) {
        		result.append(i+" ");
        	}
        }
        result.setLength(result.length()-1);
    }

    private static void check(int i) {
        Queue<Integer> q = new LinkedList<>();
        if(!edges.containsKey(i)) {
        	return;
        } else {
        	visited[i] = true;
        	for(Integer e: edges.get(i)) {
        		if(!visited[e]) {
        			q.add(e);
        		}
        	}
        }
        int tmp = 1;
        while(!q.isEmpty()) {
        	int j = q.poll();
        	
        	if(visited[j]) continue;
        	visited[j] = true;
        	canHackingCnt[j]++;
        	
        	if(!edges.containsKey(j)) continue;
        	
        	for(Integer e: edges.get(j)) {
        		if(!visited[e]) {
        			q.add(e);
        		}
        	}

        }
    }

    private static void testOutput() {
    	System.out.println(result);
    }
}