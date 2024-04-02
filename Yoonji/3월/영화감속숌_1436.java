import java.util.Scanner;

public class 영화감속숌_1436 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int count = 0;
		
		// 반복문의 범위를 어떻게 설정해주어야 하나?
		for(int i = 0; i <= Integer.MAX_VALUE; i++) {
			String number = i + "";
			
			if(number.contains("666")) {
				count++;
			}
			
			if(count == N) {
				System.out.println(number);
				break;
			}
		}

	}

}
