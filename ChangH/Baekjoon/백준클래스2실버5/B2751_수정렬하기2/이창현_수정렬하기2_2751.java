package B2751_수정렬하기2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 이창현_수정렬하기2_2751 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb= new StringBuilder();
	static int N;
	static int[] arr;
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
		arr = new int[N];
		for(int i = 0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
	}
	private static void testProcess() {
		Arrays.sort(arr);
		for(int i =0; i<N; i++) {
			sb.append(arr[i] + "\n");
		}
	}
	private static void testOutput() {
		System.out.println(sb.toString());
	}
}

