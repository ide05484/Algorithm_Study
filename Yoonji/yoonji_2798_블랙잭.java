import java.util.Scanner;

public class 블랙잭_2798 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); // 카드 장 수
		int M = sc.nextInt(); // 가까워야하는 카드 수
		
		int[] arr = new int [N]; // 카드 정보 저장할 배열 선언
		
		int max = 0; // 더한 값들 중 최대값
		
		// 카드 정보 저장
		for(int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();		
		}
		
		// 세 장 뽑으니까 3중 for문
		for(int i = 0; i < N - 2; i++) {
			for(int j = i + 1; j < N - 1;  j++) {
				for(int k = j + 1; k < N; k++) {
					int sum = arr[i] + arr[j] + arr[k];
					// 조건 충족하는지 확인, 조건 순서 유의
					// 왜 반대로 하면 값이 다르게 나올까?
					if(sum <= M && sum > max) {
						max = sum;
					}
					
				}
			}
		}
		
		System.out.println(max);
		
	}

}
