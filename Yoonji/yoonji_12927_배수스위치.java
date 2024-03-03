import java.util.Scanner;

public class yoonji_12927_배수스위치 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		
		int[] arr = new int [str.length()];
		
		// 숫자 배열로 바꿔주기
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == 'Y') {
				arr[i] = 1;
			}
		}
		
		int count = 0; // 스위치 몇번 누르는지
		
		// 배열의 맨 앞부터 반전 시작
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == 1) { // 스위치가 켜져 있으면
				count++;
				// 현재 위치 i 부터 마지막까지 돌면서
				for(int j = i; j < arr.length; j++) {
					// j가 i의 배수이면 값을 반전시켜줌
					if((j+1) % (i+1) == 0) {
						if(arr[j] == 0) {
							arr[j] = 1;
						} else {
							arr[j] = 0;
						}
					}
				}
			}
		}
		System.out.println(count);

	}

}
