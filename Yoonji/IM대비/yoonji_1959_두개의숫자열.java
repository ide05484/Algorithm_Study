import java.util.Scanner;

public class yoonji_1959_두개의숫자열 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
			
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			// 배열 입력 받기
			int[] arr1 = new int [N];
			for(int i = 0; i < N; i ++) {
				arr1[i] = sc.nextInt();
			}
			int[] arr2 = new int [M];
			for(int i = 0; i < M; i ++) {
				arr2[i] = sc.nextInt();
			}
			
			int max = 0;
			int repeat = 0;
			if(N < M) {
				repeat = M - N;
				for(int i = 0; i <= repeat; i++) { // 반복횟수
					int sum = 0;
					for(int j = 0; j < N; j++) { // 짧은 배열의 길이
						sum += arr1[j] * arr2[j+i];
						//System.out.print(arr1[j] * arr2[j+i] + " ");
					}
					//System.out.println();
					if(max < sum) {
						max = sum;
					}
				}
			} else {
				repeat = N - M;
				for(int i = 0; i <= repeat; i++) { // 반복횟수
					int sum = 0;
					for(int j = 0; j < M; j++) { // 짧은 배열의 길이
						sum += arr2[j] * arr1[j+i];
						//System.out.print(arr2[j] * arr1[j+i] + " ");
					}
					//System.out.println();
					if(max < sum) {
						max = sum;
					}
				}
				
				
			}		
			
			//양식에 맞추어 출력
			System.out.println("#" + tc + " " + max);
		}
		
	}
}
