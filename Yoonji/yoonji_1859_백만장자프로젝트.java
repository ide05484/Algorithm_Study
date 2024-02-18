import java.util.Scanner;

public class 백만장자프로젝트_1859 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		// 테케 수만큼 반복
		for(int tc = 1; tc <= T; tc++) {
			// 입력값 수
			int N = sc.nextInt();
			// 만큼의 배열 선언하고
			int[] arr = new int [N];
			// 날짜별 주식 값 넣어줌
			for(int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}
			// 최대값을 배열의 맨 마지막 값으로 설정
			int max = arr[arr.length - 1];
			
			long sum = 0;
			// 뒤에서 두번째 값부터 max와 비교
			for(int i = arr.length - 2; i >= 0; i--) {
				// max 보다 크다면 max를 교체하고
				if(arr[i] > max) {
					max = arr[i];
				} else {
					// 최대값보다 작다면 max에서 날짜를 빼고, 그 차익을 sum에 누적하여 저장
					sum += max - arr[i];
				}
			}
			
			System.out.println("#" + tc + " " + sum);
					
		}
	}

}