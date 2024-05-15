package B1931;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N, now, result; // 회의 예약 요청 수, 현재 시간, 결과
	static PriorityQueue<Point> pq = new PriorityQueue<>(new Comparator<Point>() {

		@Override
		public int compare(Point o1, Point o2) {
			if(o1.y == o2.y) {
				return o1.x - o2.x;
			}
			return o1.y - o2.y;
		}
		
	}); //끝나는 시간 우선, 끝나는 시간이 같다면 시작하는 시간 우선
	
	public static void main(String[] args) throws IOException {
		test();
	}
	static void test() throws IOException {
		testInput();
		testProcess();
		testOutput();
	}
	static void testInput() throws IOException{
		N = Integer.parseInt(br.readLine().trim());
		for(int i = 0 ; i<N; i++) {
			st = new StringTokenizer(br.readLine().trim());
			pq.add(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
	}
	static void testProcess() {
		while(!pq.isEmpty()) { 
			Point p = pq.poll(); //뽑아서 
			if(p.x<now)  //시작 가능하면
				continue; //시작해
			now = p.y; //끝나는 시간이 새로운 현재 시간
			result++; // 뽑았으니 ++
		}
	}
	static void testOutput() {
		System.out.println(result);
	}
}
