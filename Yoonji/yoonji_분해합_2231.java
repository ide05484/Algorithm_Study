import java.util.Scanner;

public class yoonji_분해합_2231 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		// 나중에 다 돌고 나온 경우의 출력 체크를 위해
		int check = 1;
		
		// 적어도 숫자 N 만큼 반복하는데
		for(int i = 0; i <= N; i++) {
			
			// 변수를 따로..!! i로 바로 쓰면 안됨
			// while에서 나눠줄 것이기 때문에 변수로 빼서 쓰기
			int num = i;
			int result = 0; // 결과 저장할 변수
			result = result + num; // 숫자 N을 결과에 더해주고
			
			// 현재 살펴보는 숫자 num이 10으로 나눠질 수가 있을 때
			while(num > 0) {
				result = result + num % 10; //일의 자리를 더해줌
				num = num / 10; // 10으로 나눈 몫을 숫자에 저장(일의 자리를 없어짐!)
			}
			
			// 결과: num더하고 각 자리수 더한 것이 N과 같을 때
			if(result == N) {
				System.out.println(i);
				check = 0; // 출력되는 값이 있다.
				break;
			}
			
		}
		
		// 다 돌고 나온 경우는 분해합이 없는 경우임, 체크가 0으로 바뀌질 않았으면
		if(check == 1) {
			System.out.println(0);
		}

	}

}
