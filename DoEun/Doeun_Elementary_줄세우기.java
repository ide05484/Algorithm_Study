package IM;

import java.util.Arrays;
import java.util.Scanner;

public class Elementary_줄세우기 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt(); // 테케갯수

		for (int tc = 1; tc <= T; tc++) {

			int test = sc.nextInt(); // 테케 번호

			int[] student = new int[20]; // 학생들의 키 받을 배열
			int[] studentArr = new int[20]; // 재정렬되는 배열

			int count = 0; // 뒤로옮기는 발걸음

			for (int n = 0; n < 20; n++) {
				student[n] = sc.nextInt();// 학생키 받음1
			}

			studentArr[0] = student[0]; // 처음은 일단 넣음

			int idx = 0; // 인덱스 값

			for (int n = 1; n < 20; n++) { // 그 뒤부터
				int max = 0; // 차이 값의 최대
				// 만약 바로 앞이 나보다 작거나 같으면 일단 넣어주셈
				if (student[n] >= studentArr[n-1]) {
					studentArr[n] = student[n];
					continue;
				}
				for (int k = n - 1; k >= 0; k--) { // 해당 인덱스 앞을 살펴봄
					max = Math.max(max, student[n] - studentArr[k]); // 차이가 최대인 것 갱신

					if (max == student[n] - studentArr[k]) { // 차이가 최대인 인덱스 값!
						idx = k;
					}
				} // 최대 인덱스 구함
//				System.out.println(idx);

				for (int i = n; i > idx; i--) {
					studentArr[i] = student[i - 1]; // 뒤로 한칸씩 땡겨주고
					count++; // 옮길때마다 카운트
				}

				studentArr[idx] = student[n];
//				System.out.println(Arrays.toString(studentArr));
			} // 20명 다돔

//			System.out.println(Arrays.toString(studentArr));
			System.out.println("#" + test + " " + count);
		} // 테케마감
	}// main마감
}
