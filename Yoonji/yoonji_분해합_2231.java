import java.util.Scanner;

public class yoonji_분해합_2231 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		// 적어도 숫자 N 만큼 반복하는데
		// num 대신 다른 변수를..!!
		// 일의 자리면 없어야 함 두둥 조건문 하나 더 달아주면 됨

		for(int i = 0; i <= N; i++) {
			int num = i; // 변수를 따로..!!
			int result = 0;
			result = result + num; // 숫자 N을 결과에 더해주고
			// 숫자가 10으로 나눠질 수가 있을 때
			while(num > 0) {
				result = result + num % 10; //일의 자리를 더해줌
				num = num / 10; // 10으로 나눈 몫을 숫자에 저장(일의 자리를 없어짐!)
			}
			if(result == N) {
				System.out.println(i);
				break;
			}
			
		}
		
		

	}

}
