import java.util.Scanner;

public class yoonji_2559_수열 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); // 총 입력받는 값의 수
		int K = sc.nextInt(); // 그 중에서 K개 만큼의 합을 찾아야 함
		
		int[] arr = new int [N];
		// 값 입력 받음
		for(int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		
		// 부분합 중 최고값을 저장할 max
		// 입력값에 -도 있기 때문에 0말고 이렇게 지정함
		int max = Integer.MIN_VALUE;
		// (N - K)같거나 작을 떄까지 봄 (그 이후는 다음 for문에서 봄)
		for(int i = 0; i <= N - K; i++) {
			// 현재의 부분합을 저장할 sum
			int sum = 0;
			// i부터 K + i까지, 배열의 처음부터 끝까지 K개 만큼만 살펴봄
			for(int j = i; j < K+i; j++) {
				sum += arr[j];
			}

			// 부분합이 max 보다 크다면 더해준다.
			if(sum > max) {
				max = sum;
			}
		}
		
		System.out.println(max);
		

	}

}
