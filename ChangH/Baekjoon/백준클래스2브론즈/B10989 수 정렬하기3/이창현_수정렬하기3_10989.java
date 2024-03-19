package B10989;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int N;
	static int[] Countedarr= new int[10001];
	public static void main(String[] args) throws IOException, Exception {
		test();
	}
	private static void test() throws IOException, Exception {
		testInput();
		testProcess();
		testOutput();
	}
	private static void testInput() throws Exception, IOException {
		N = Integer.parseInt(br.readLine());
		
		for(int i = 0 ;i<N; i++) {
			Countedarr[Integer.parseInt(br.readLine())]++;
		}
	}
	private static void testProcess() {
		for(int i = 0 ;i<=10000; i++) {
			if(Countedarr[i]>0) {
				for(int j = 0; j<Countedarr[i];j++) {
					sb.append(i+"\n");
				}
			}
		}
	}
	private static void testOutput() {
		System.out.println(sb.toString());
	}

}
