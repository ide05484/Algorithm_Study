import java.math.BigInteger;
import java.util.Scanner;

public class 팩토리얼0의개수_1676 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 숫자 입력받기
		int N = sc.nextInt();
		BigInteger result = new BigInteger("1");
		
		// 팩토리얼 구하기
		while(N > 0) {
			result = result.multiply(BigInteger.valueOf(N));
			N--;
		}
		
		// 문자열로 바꾸기
		String Number = result + "";
		// 0의 개수를 count
		int count = 0;
		
		// 뒤에서부터 세기 위해서 length 지정
		int length = Number.length() - 1;
		
		// 뒤에서부터 한 자리씩 줄이면서 0인지 비교
		while(length >= 0) {
			// 0이면 count 증가, 아니라면 break;
			if(Number.charAt(length) == '0') {
				count++;
			} else {
				break;
			}
			length--;
		}
		
		System.out.println(count);
	}

}
