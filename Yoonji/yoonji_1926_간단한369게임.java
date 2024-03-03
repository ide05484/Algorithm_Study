import java.util.Scanner;

public class yoonji_1926_간단한369게임 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		String[] str = new String [N];
		// 숫자 값 문자열로 배열에 받기
		for(int i = 0; i < N; i++) {
			str[i] = Integer.toString(i+1);
		};
		
		// 형식에 맞게 출력하기
		for(int i = 0; i < N; i++) {
			// 3 6 9 있는지 체크, 숫자마다 초기화
			int check = 0;
			
			// 3 6 9 일때 - 출력
			for(int j = 0; j < str[i].length(); j++) {
				
				if(str[i].charAt(j) == '3') {
					System.out.print('-');
					check++;
				}
				
				else if(str[i].charAt(j) == '6') {
					System.out.print('-');
					check++;
				}
				
				else if(str[i].charAt(j) == '9') {
					System.out.print('-');
					check++;
				}
							
			}
			
			// 3 6 9 없으면 숫자 출력
			if(check == 0) {
				System.out.print(str[i]);
			}
			
			// 공백으로 구분
			System.out.printf(" ");
			
		}
		
	}

}
