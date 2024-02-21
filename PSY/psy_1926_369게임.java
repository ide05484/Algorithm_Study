import java.util.Scanner;

public class psy_1926_369게임 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		for (int i = 1; i <= N; i++) { // 1부터 N까지 출력
			String str = Integer.toString(i); // 문자형으로 변환
			int flag = 0;
			for (int j = 0; j < str.length(); j++) { // 숫자 하나하나 탐색
				if (str.charAt(j) == '3' || str.charAt(j) == '6' || str.charAt(j) == '9') {
					System.out.print("-");
					flag = 1;
				}
				if (flag == 1 && j == str.length() - 1) // 띄어쓰기
					System.out.print(" ");
			}
			if(flag == 0) // 숫자에 3,6,9가 포함되어있지 않다면
			System.out.print(str + " ");
		}
	}
}
