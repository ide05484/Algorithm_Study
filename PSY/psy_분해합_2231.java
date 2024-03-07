
import java.util.Scanner;

public class psy_분해합_2231 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 입력 값
		int flag = 0; // 출력 값
		for (int i = 1; i <= N; i++) { // N까지 돌면서 확인
			int num = i; // 임시 다음 수
			int sum = num;
			while (num > 0) { // 1의 자리수부터 더해주기
				sum += num % 10;
				num /= 10;
			}
			if (sum == N) { // 같으면 값 저장
				flag = i;
				break;
			}
		}
		System.out.println(flag);
	}
}
