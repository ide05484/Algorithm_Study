import java.util.Scanner;

public class yoonji_1978_소수찾기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[] arr = new int [N];
		
		
		int result = 0; // 결과
		
		for(int i = 0; i < N; i++) {
			int count = 1; // 소수일때 더할 수
			
			arr[i] = sc.nextInt();
			// 1은 소수가 아님
			if(arr[i] == 1) {
				// 다음 반복문으로 넘어가기
				continue;
			}
			// 2부터 숫자보다 작을 때
			for(int j = 2; j < arr[i]; j++) {
				// 나눠지면 소수가 아님
				if(arr[i] % j == 0) {
					count = 0;
					break;
				}	
			}
			
			result += count;
		}
		
		System.out.println(result);
		
		

	}

}
