package B2798;

import java.util.Scanner;

public class 이창현_블랙잭_2798 {
	static Scanner sc = new Scanner(System.in);
	static int N, M, result;
	static int[] deck; //n배열
	public static void main(String[] args) {
		test();
	}
	private static void test() {
		testInput();
		testProcess();
		testOutput();
	}
	private static void testInput() {
		N= sc.nextInt();
		M= sc.nextInt();
		deck = new int[N];
		for(int i = 0 ; i<N; i++) {
			deck[i] = sc.nextInt();
		}
	}
	private static void testProcess() {
		for(int i = 0; i<N-2; i++) {
			if(deck[i]>M) { //합이 이미 넘었으면 반환
				continue;
			}
			for(int j= i+1; j<N-1; j++) {
				if(deck[i]+deck[j]>M) { //합이 이미 넘었으면 반환
					continue;
				}
				for(int k = j+1; k<N; k++) {
					if(deck[i]+deck[j]+deck[k]<=M) { //M을 넘지 않으면서
						result = Math.max(result, deck[i]+deck[j]+deck[k]); //가장 큰수
					}
				}
			}
		}
	}
	private static void testOutput() {
		System.out.println(result);
	}
}
