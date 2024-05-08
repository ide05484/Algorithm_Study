package B13023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	//입력 도구
	static int N, M; //사람 수, 친구 관계 수
	static Map<Integer, List<Integer>> map;
	//입력 데이터 변수
	static boolean[] visited;
	//방문 여부
	static boolean result;
	//출력 데이터
	public static void main(String[] args) throws IOException {
		test();
	}

	private static void test() throws IOException {
		testInput(); //입력
		testProcess(); //처리
		testOutput(); //출력
	}

	private static void testInput() throws IOException {
		st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new HashMap<>();
		for(int i = 0 ; i<N; i++) {
			map.put(i, new ArrayList<>());
		}
		for(int i = 0 ; i< M; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			map.get(a).add(b);
			map.get(b).add(a);
			//관계는 단반향이라고 말 없었음, 일반적인 관계는 양방향 관계
		}
		visited = new boolean[N]; // 방문 여부 도구 초기화
	}

	private static void testProcess() {
		for(int i = 0; i<N; i++) {
			if(!map.get(i).isEmpty()) {
				if(check(i, 0)) {
					result = true;
					return;
				}
			}
		}
		//친구가 있는 모든 인원으로부터 출발해서 체크
	}

	private static boolean check(int x, int repeat) {
		if(visited[x]) return false; // 방문했으면 나가
		if(repeat>=4) return true; // 4줄 살피면 5명 완성
		visited[x] = true; // 방문 처리
		List<Integer> list = map.get(x);
		for(int i = 0; i<list.size(); i++) {
			if(!visited[list.get(i)] && check(list.get(i), repeat+1)) {
				return true; // 방문하지 않은 곳 체크, 만약 true가 뜨면 바로 리턴 반복
			}
		}
		visited[x] = false; //방문 초기화
		return false; // 실패한 경로
	}

	private static void testOutput() {
		System.out.println(result? 1: 0); //결과 출력
	}
	
}
