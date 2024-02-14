
import java.util.Scanner;

public class 롤케이크_3986 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int L = sc.nextInt();
		int N = sc.nextInt();
		
		int[] arr = new int [L+1];
		int count = 1;
		int expectMax = 0; // 예상되는 제일 많이 받아갈 사람
		int expect = 0; // 예상값
		
		// 숫자 입력 받기
		for(int i = 1; i <= N; i++) {
			int num1 = sc.nextInt();
			int num2 = sc.nextInt();
			// 배열에 알맞게 넣어주기
			for(int j = num1 ; j <= num2; j++) {
				if(arr[j]==0) {
					arr[j] = count;
				}
			}
			// 예상값을 갱신하면서, 최대 예상값의 사람을 출력
			if(expect < num2 - num1 + 1) {
				expect = num2 - num1 + 1;
				expectMax = count;
			}
			count++;//사람
		}
		// 실제 받아가는 값 계산을 위한 카운팅 배열 선언
		int[] counting = new int [1001];
		for(int i = 0; i < arr.length; i++) {
			counting[arr[i]]++;
		}
		
		counting[0] = 0; // 0번째를 0으로 수정
		
		int real = 0; // 각자 받아가는 값
		int realMax = 0; // 실제 많이 받아가는 사람
		for(int i = 0; i < counting.length; i++) {
			// 각자 받아가는 값을 갱신하면서, 최대로 정말 가져가는 사람을 출력
			if(counting[i] > real) {
				real = counting[i];
				realMax = i;
			}
		}
		
		System.out.println(expectMax); // 예상 많이 가져가는 사람
		System.out.println(realMax); // 실제 많이 받아가는 사람
		
		
	}

}
