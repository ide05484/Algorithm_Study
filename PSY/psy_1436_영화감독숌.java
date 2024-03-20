package swea;

import java.util.Scanner;

public class psy_1436_영화감독숌 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int result = 666; // 결과
		int count = sc.nextInt();
		while (count > 0) {
			if(check(result)) { // 체크
				count--;
			}
			result++;
		}
		System.out.println(--result);
	}
	
	static boolean check(int N) { //체크 로직
		int count  = 0;
		String str = Integer.toString(N);
		for(int i = 0; i < str.length();i++) {
			if(str.charAt(i)=='6')
				count++;
			else count = 0;
			if(count == 3)
				return true;
		}
		return false;
	}
}
