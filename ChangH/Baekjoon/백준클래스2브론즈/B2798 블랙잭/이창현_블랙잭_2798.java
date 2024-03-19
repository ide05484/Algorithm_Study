package B2798;

import java.util.Scanner;

public class 이창현_블랙잭_2798 {
	static Scanner sc = new Scanner(System.in);
	static int N, M, result; //N, M, 결과 선언
	static int[] deck; //n배열
	public static void main(String[] args) {
		test(); //테스트
	}
	private static void test() {
		testInput(); //입력
		testProcess(); //실행
		testOutput(); //출력
	}
	private static void testInput() {
		N= sc.nextInt(); //N
		M= sc.nextInt(); //M
		deck = new int[N]; //놓인 숫자
		for(int i = 0 ; i<N; i++) {
			deck[i] = sc.nextInt(); //덱 받아오기
		}
	}
	private static void testProcess() {
		//총 3개의 카드를 선택하는 것을 전부 탐색함
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
