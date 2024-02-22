import java.util.Scanner;

public class 당근 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
			
			int N = sc.nextInt();
			
			int[] arr = new int [N];
			
			for(int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}
			
			int max = 1;
			int count = 1;
			for(int i = 0; i < N - 1; i++) {
				if(arr[i] < arr[i+1]) {
					count++;
					if(max < count) {
						max = count;
					}
				} else {
					count = 1;
				}
			}
			System.out.println("#" + tc + " " + max);
		}

	}

}
