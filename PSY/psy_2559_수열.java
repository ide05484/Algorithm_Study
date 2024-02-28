import java.util.Scanner;

public class psy_2559_수열 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int K = sc.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < N-K+1;i++) {
			int sum = 0;
			for(int j = 0; j < K;j++) {
				sum += arr[i+j];
			}
			if(sum > max)
				max =sum;
		}
		System.out.println(max);
		
	}
}
