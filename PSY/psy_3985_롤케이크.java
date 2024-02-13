package swea7;

import java.util.Scanner;

public class psy_3985_롤케이크 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int L = sc.nextInt(); // 롤 케이크 길이
		int N = sc.nextInt(); // 사람 수

		int[] arr = new int[L]; // 롤 케이크 배열
		int result1 = 0; // 기대 최대 값
		int result2 = 0; // 실제 최대 값
		int max1 = Integer.MIN_VALUE;
		int max2 = Integer.MIN_VALUE;
		for (int i = 1; i <= N; i++) {
			int p = sc.nextInt() - 1; // 인덱스 때문에 -1
			int k = sc.nextInt() - 1;

			if (max1 < k - p) { // 기대 최대 값 갱신
				max1 = k - p;
				result1 = i;
			}
			int count = 0; // 해당 사람이 받을 수 있는 실제 최대 값
			for(int j = p; j <= k;j++) {
				if(arr[j]==0) {
					arr[j]++;
					count++;
				}
			}
			if(max2 < count) { // 실제 최대 값 갱신
				max2 = count;
				result2 = i;
			}
		}
		System.out.println(result1); // 출력
		System.out.println(result2);
	}
}
