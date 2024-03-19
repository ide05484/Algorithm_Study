package swea;

import java.util.Arrays;
import java.util.Scanner;

public class psy_1181_박상용 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		String[] arr = new String[N]; // 입력받는 문자열
		String[] result = new String[N]; // 결과 문자열
		int[] count = new int[51]; // counting 배열
		for (int i = 0; i < N; i++) { // 배열 입력 받기 및 길이 변수
			arr[i] = sc.next();
			count[arr[i].length()]++;
		}

		int num = 0;
		for (int i = 1; i < 51 && num <= N; i++) { // 글자수 1부터 돌기
			int arridx = 0;
			if (count[i] == 0)
				continue;
			String[] arr1 = new String[count[i]]; // 현재 글자수 개수만큼크기의 배열 생성
			for (int j = 0; j < N; j++) { // 해당 길이 동일한 문자열 넣고 정렬
				if (i == arr[j].length()) {
					arr1[arridx++] = arr[j];
				}
			}
			Arrays.sort(arr1);
			for (int j = 0; j < arr1.length; j++) { // 결과에 담기
				result[num++] = arr1[j];
			}
		}
		System.out.println(result[0]);
		for (int i = 1; i < N; i++) {
			if (result[i].equals(result[i - 1]))
				continue;
			System.out.println(result[i]);
		}
	}
}
