import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class 종이자르기_2628 {
	
	/*
	 *  가로 세로로 자르는 곳의 지점을 찾고,
	 *  각 차이를 빼준 뒤에 서로 곱해서 모든 종이의 크기 확인
	 *  최대값 하나만 출력
	 */

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int x = sc.nextInt();
		int y = sc.nextInt();
		int N = sc.nextInt();
		
		// 처음 좌표 값 입력받을 어레이리스트
		ArrayList<Integer> R = new ArrayList<Integer>();
		ArrayList<Integer> C = new ArrayList<Integer>();
		
		// 가로로 자르면 R, 세로로 자르면 C에 넣어주기
		for(int i = 0; i < N; i++) {
			int r = sc.nextInt();
			int c = sc.nextInt();
		// 어느 방향으로 자를지	
			if(r==0) {
				R.add(c);
			} else if (r == 1) {
				C.add(c);
			}
		}
		// 최고 크기도 넣어주기
		R.add(y);
		C.add(x);
		
		// 정렬하기
		Collections.sort(R);
		Collections.sort(C);
		
		// 순서대로 출력 확인
//		System.out.println("R: " + R); [2, 3, 8]
//		System.out.println("C: " + C); [4, 10]
		
		// 각 좌표들의 차이를 저장할 새로운 어레이 리스트 선언
		ArrayList<Integer> A = new ArrayList<Integer>();
		ArrayList<Integer> B = new ArrayList<Integer>();
		
		// 처음꺼 넣어주고		
		A.add(R.get(0));
		// 다음꺼 - 지금꺼 값 넣기 반복
		for(int i = 1; i < R.size(); i++) {
			A.add(R.get(i)-R.get(i-1));
		}
		
		B.add(C.get(0));
		for(int i = 1; i < C.size(); i++) {
			B.add(C.get(i)-C.get(i-1));
		}
		// 좌표들의 차이
		System.out.println("A: " + A); //[2, 1, 5]
		System.out.println("B: " + B); //[4, 6]
		
		// 각 차이들을 곱해서 종이 넓이 구함
		int max = 0;
		for(int i = 0; i < A.size(); i++) {
			for(int j = 0; j < B.size(); j++) {
				int sum = A.get(i) * B.get(j);
				// 최대값 갱신
				if(max < sum) {
					max = sum;
				}
			}
		}
		
		System.out.println(max);

	}
}
