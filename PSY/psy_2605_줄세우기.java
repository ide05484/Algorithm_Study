package swea8;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class psy_2605_줄세우기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Integer> list = new ArrayList<>();
		int N = sc.nextInt();
		
		for(int i = 1;i <= N; i++) { // 값 추가
			list.add(list.size()-sc.nextInt(),i); //add(1,2) -> 인덱스 1에 숫자 '2'추가
		}
		for(int i = 0;i < N; i++) { // 출력
			System.out.print(list.get(i)+" ");
		}
	}
}
