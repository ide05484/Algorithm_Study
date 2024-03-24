package 알고리즘_응용;

import java.util.Scanner;

public class N과M_2_15650 {
	static int N; // 여기에서
	static int M; // M개 구하기

	static boolean[] sel; // 선택된거 체크해주기

	static int[] arr; // 자연수 배열
	static int[] answer; // 정답배열

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt(); // 여기에서
		M = sc.nextInt(); // M개 구하기

		arr = new int[N];
		answer = new int[M];
		sel = new boolean[N];

		for (int i = 0; i < N; i++) {
			arr[i] = i + 1; // 자연수 넣어주기
		}

		comb(0, 0);

	}

	// num은 고려하는 재료 종류, idx는 선택하는 재료 인덱스
	private static void comb(int num, int idx) {

		if (idx >= M) { // 재료를 다 채우면 일단 리턴

			for (int i = 0; i < M; i++) {
				System.out.print(answer[i] + " ");
			}
			System.out.println();
			return;
		}

		if (num >= N) { // 재료를 다 채우지 않앗는데 재료를 모두 고려했다면 return
			return;
		}

		sel[num] = true;
		answer[idx] = arr[num];
		comb(num+1, idx+1);
		
		sel[num] = false;
		comb(num+1, idx);

	}
}
