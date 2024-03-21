package baekjoon_class2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 영화감독숌_1436 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // N번째 영화 수

		int n = 666;
		int count = 1;

		while (count != N) {
			n++;
			if(String.valueOf(n).contains("666")) {
				count++;
			}
		}
		
		System.out.println(n);
	}
}

//public class 영화감독숌_1436 {
//	public static void main(String[] args) {
//
//		Scanner sc = new Scanner(System.in);
//
//		int N = sc.nextInt(); // N번째 영화 수
//
//		List<String> list = new ArrayList<>();
//
//		for (int i = 0; i < 3; i++) {
//			list.add("6"); // 6을 일단 4개 넣어줌 = 첫 숫자
//		}
//
//		out: for (int n = 0; n < N; n++) {
//			list.set(0, String.valueOf(n % 10));
//			// 만약에 처음 세개가 666 이라면 뒤에 자리를 바꿔주세오
//			if (checkNum(list)) {
//				// true라면 뒤에 맘껏 붙이자
//				int count = 0;
//				while (count == 9) {
//					list.set(list.size() - 1, String.valueOf(count));
//					count++;
//					if (n == N - 1) {
//						break out;
//					}
//				}
//				// 다 추가했다면?
//				list.remove(list.size() - 1);
//				continue;
//			}
//		}
//		
//		for (int i = 0; i < list.size(); i++) {
//			System.out.print(list.get(i));
//		}
//
//	}
//
//	private static boolean checkNum(List<String> list) {
//		// 첫 3개가 666이라면 true를 반환하자! -> 그 뒤는 마음껏 해도 된다
//		for (int i = 0; i < 3; i++) {
//			if (!list.get(i).equals("6")) {
//				return false;
//			}
//		}
//		return true;
//	}
//
//}
