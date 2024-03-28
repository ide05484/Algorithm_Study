package 알고리즘_응용;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N과M_4_15652 {
	static int N; // 여기에서
	static int M; // M개 구하기

//	static int[] arr; // 자연수 배열
//	static boolean[] sel; // 선택배열
	static int[] answer; // 정답배열
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {

		// 시간초과 떴ㄷ ㅏ. ..
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

//		arr = new int[N];
		answer = new int[M];
//		sel = new boolean[N];

//		for (int i = 0; i < N; i++) {
//			arr[i] = i + 1; // 자연수 넣어주기
//		}

		comb(0, 0);
		System.out.println(sb);

	}

	// num은 고려하는 재료 종류, idx는 선택하는 재료 인덱스
	private static void comb(int num, int idx) {

		if (idx >= M) { // 재료를 다 채우면 일단 리턴

			for (int i = 0; i < M; i++) {
				sb.append(answer[i] + " ");
			}
			sb.append("\n");
			return;
		}

		if (num >= N) { // 재료를 다 채우지 않앗는데 재료를 모두 고려했다면 return
			return;
		}

		for (int i = num; i < N; i++) {
				answer[idx] = i + 1; // 일단 첫번째꺼 넣어줌
				comb(num++, idx + 1);
				//++해줘야 다음 num이 바뀜! -> 값을 바꿔주는 부수효과가 있다
		}
	}
}
