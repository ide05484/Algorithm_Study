package B10816_숫자카드2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 이창현_숫자카드2_10816 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N, M;
	static int[] counted = new int[20000001];
	static int[] order;
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static String result;
	public static void main(String[] args) throws NumberFormatException, IOException {
		test();
	}
	private static void test() throws NumberFormatException, IOException {
		testInput();
		testProcess();
		testOutput();
	}
	private static void testInput() throws NumberFormatException, IOException {
		N= Integer.parseInt(br.readLine());
		st= new StringTokenizer(br.readLine());
		for(int i = 0 ; i< N ; i++) {
			counted[Integer.parseInt(st.nextToken())+10000000]++;
		}
		M= Integer.parseInt(br.readLine());
		order = new int[M];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<M;i++) {
			order[i]=Integer.parseInt(st.nextToken())+10000000;
		}
	}
	private static void testProcess() {
		for(int i = 0 ; i<M; i++) {
			sb.append(counted[order[i]]+" ");
		}
		result = sb.toString();
	}
	private static void testOutput() {
		System.out.println(result);
	}
}
